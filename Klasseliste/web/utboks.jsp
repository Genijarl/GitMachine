<%-- 
    Document   : innboks
    Created on : 15.nov.2018, 13:55:37
    Author     : Øyvind
--%>
<%@page import="Verktoy.DBVerktoy"%>
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
                        <a href ="innboks.jsp"> Innboks </a> 
                        <a href="ePost.jsp"> Ny Epost </a>
                </div> 
            
        <h1>Sendte Mail</h1>
        <%
            //Oppretter kommunikasjon med databasen classlist
            DBVerktoy dbVerktoy = new DBVerktoy();
                         try (Connection conn = dbVerktoy.loggInn2()){

                    String sqlString = "SELECT mottaker_id, epost_adr, epost_emne, epost_melding, email_sendt"
                    + " FROM outgoingEmail"
                    + " GROUP BY mottaker_id"
                    + " ORDER BY mottaker_id DESC";
                    Statement myStatement = conn.createStatement();
                    ResultSet rs=myStatement.executeQuery(sqlString);
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
    while (rs.next()) { %>
        <tr>
            <td><%= rs.getString("mottaker_id") %></td>
            <td><%= rs.getString("epost_adr") %></td>
            <td><%= rs.getString("epost_emne") %></td>
            <td><%= rs.getString("epost_melding") %></td>
            <td><%= rs.getString("email_sendt") %></td>
        </tr>
        <% }
            rs.close();
            myStatement.close();
            conn.close();
        %>
        <%  }catch(Exception e){e.printStackTrace();}    %>
    </tbody>
</table>