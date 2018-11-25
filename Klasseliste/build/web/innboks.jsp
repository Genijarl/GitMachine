<%-- 
    Document   : innboks
    Created on : 27.okt.2018, 12:43:15
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
        
    </head>
    <body>
        
        <h1>Innboks</h1>
        <%!
            //Oppretter kommunikasjon med databasen classlist
            public class Innboks {
                String URL = "jdbc:mysql://localhost:3306/classlist";
                String USERNAME = "root";
                String PASSWORD = "root";


                Connection connection = null;
                PreparedStatement seInnboks = null;
                ResultSet resultSet = null;

                public Innboks() {
                
                //Henter attributter fra tabellen innboks i databasen som skal brukes
                try {

                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                    seInnboks = connection.prepareStatement(
                    "SELECT inn_nr, inn_sender, inn_emne, inn_meld"
                    + " FROM innboks");

                } catch (SQLException e){
                e.printStackTrace();
                }

             }

                public ResultSet getInnboks(){
                
                try {
                    resultSet = seInnboks.executeQuery();
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
                //Koden lager et objekt av innboksen.
                //Her henter den det som står i tabellen innboks i SQL.
                Innboks innboks = new Innboks();
                ResultSet innboksen = innboks.getInnboks();
%>
<table border="1">
    <tbody>
        <tr>
            <td>NR</td>
            <td>AVSENDER</td>
            <td>EMNE</td>
            <td>MELDING</td>
            <td>SVAR</td>
        </tr>
        
        <% 
            //While loopen kjører slik at den henter alle meldinger i innboksen
            //Når den ikke finner fler meldinger så stopper den.
            while (innboksen.next()) { %>
        <tr>
            <td><%= innboksen.getString("inn_nr") %></td>
            <td><%= innboksen.getString("inn_sender") %></td>
            <td><%= innboksen.getString("inn_emne") %></td>
            <td><%= innboksen.getString("inn_meld") %></td>
            <td><a href="ePost.jsp" ><h3> Svar <h3></a></td>
        </tr>
        <% } %>
    </tbody>
</table>