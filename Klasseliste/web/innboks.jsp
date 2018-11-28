<%-- 
    Document   : innboks
    Created on : 27.okt.2018, 12:43:15
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
        
    </head>
    <body>
        
        <h1>Innboks</h1>
        <%
            //Oppretter kommunikasjon med databasen classlist
            DBVerktoy dbVerktoy = new DBVerktoy();
                         try (Connection conn = dbVerktoy.loggInn2()){

                                String sqlString = "SELECT inn_nr, inn_sender, inn_emne, inn_meld FROM innboks";
                                Statement myStatement = conn.createStatement();
                                ResultSet rs=myStatement.executeQuery(sqlString);
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
            while (rs.next()) { %>
        <tr>
            <td><%= rs.getString("inn_nr") %></td>
            <td><%= rs.getString("inn_sender") %></td>
            <td><%= rs.getString("inn_emne") %></td>
            <td><%= rs.getString("inn_meld") %></td>
            <td><a href="ePost.jsp" ><h3> Svar <h3></a></td>
        </tr>
        
        <% } rs.close();
             conn.close();
             myStatement.close();%>
        <%  }catch(Exception e){e.printStackTrace();}    %>
    </tbody>
</table>