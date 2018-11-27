<%-- 
    Document   : seProgresjon
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
        
        <h1>Min Progresjon</h1>
        <%
            //Oppretter kommunikasjon med databasen classlist
                                    DBVerktoy dbVerktoy = new DBVerktoy();
                         try (Connection conn = dbVerktoy.loggInn2()){

                                String sqlString = "SELECT id FROM files";
                                Statement myStatement = conn.createStatement();
                                ResultSet rs=myStatement.executeQuery(sqlString);

                                String sqlString2 = "SELECT m_id FROM modulelist";
                                Statement myStatement2 = conn.createStatement();
                                ResultSet rs2=myStatement2.executeQuery(sqlString2);

            //While loopen kjører slik at den henter antall leverte moduler.
            //Den andre while loopen henter antall moduler opprettet.
            while (rs.last()) { %>
        <tr>
            <td><%= rs.getString("id") %></td>
            <td>/</td>
        <% break;} %>
        <%    while (rs2.last()) { %>
        <td><%= rs2.getString("m_id") %> Moduler levert</td>
        <% break;} %>
        </tr>
      <%  }catch(Exception e){e.printStackTrace();}    %>
    </tbody>
</table> 