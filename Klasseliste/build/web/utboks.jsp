<%-- 
    Document   : innboks
    Created on : 15.nov.2018, 13:55:37
    Author     : Øyvind
--%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LES</title>
                  <link rel="stylesheet" href="index.css" type="text/css"/>
                        <title>Klasseliste IS-109/110</title>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <link rel="stylesheet" type="text/css" href="index.css">
        </head>     
        <body>
                <div>
                        <a href ="index.html"> Hjem </a>
                        <a href ="innboks.jsp"> Innboks </a> 
                        <a href="ePost.jsp"> Ny Epost </a>
                </div> 
            
        <h1>Sendte Mail</h1>
        <%!
            //Oppretter kommunikasjon med databasen classlist
            public class Utboks {
                String URL = "jdbc:mysql://localhost:3306/classlist";
                String USERNAME = "root";
                String PASSWORD = "Cxwq809qa6";


                Connection connection = null;
                PreparedStatement seUtboks = null;
                ResultSet resultSet = null;

                public Utboks() {
                
                //Henter attributter fra tabellen outgoingEmail i databasen som skal brukes
                try {

                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                   seUtboks = connection.prepareStatement(
                    "SELECT mottaker_id, epost_adr, epost_emne, epost_melding, email_sendt"
                    + " FROM outgoingEmail"
                    + " GROUP BY mottaker_id"
                    + " ORDER BY mottaker_id DESC");

                } catch (SQLException e){
                e.printStackTrace();
                }

             }

                public ResultSet getUtboks(){
                
                try {
                    resultSet = seUtboks.executeQuery();
                }
                catch
                (SQLException e){
                e.printStackTrace();
                }

                return resultSet;

           }
}
            %> 
            <%
                //Koden lager et objekt av utboksen.
                //Her henter den det som står i tabellen outgoingEmail i SQL.
                Utboks utboks = new Utboks();
                ResultSet utboksen = utboks.getUtboks();
%>
<table border="1">
    <tbody>
        <tr>
            <td>NR</td>
            <td>SENDT TIL</td>
            <td>EMNE</td>
            <td>MELDING</td>
            <td>SENDT</td>
        </tr>
        
        <% 
            //While loopen kjører slik at den henter alle meldinger i utboksen
            //Når den ikke finner fler meldinger så stopper den.
    while (utboksen.next()) { %>
        <tr>
            <td><%= utboksen.getString("mottaker_id") %></td>
            <td><%= utboksen.getString("epost_adr") %></td>
            <td><%= utboksen.getString("epost_emne") %></td>
            <td><%= utboksen.getString("epost_melding") %></td>
            <td><%= utboksen.getString("email_sendt") %></td>
        </tr>
        <% } %>
    </tbody>
</table>