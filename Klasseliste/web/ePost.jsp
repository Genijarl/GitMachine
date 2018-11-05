<%-- 
    Document   : ePost
    Created on : 23.okt.2018, 18:34:15
    Author     : oyvin
--%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ny Epost</title>
    </head>
    <body>
        <h1>Ny Epost</h1>
        <%!
            public class Epost {
                String URL = "jdbc:mysql://localhost:3306/classlist";
                String USERNAME = "root";
                String PASSWORD = "Cxwq809qa6";


                Connection connection = null;
                PreparedStatement insertEpost = null;
                ResultSet resultSet = null;

                public Epost() {

                try {

                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                    insertEpost = connection.prepareStatement(
                    "INSERT INTO outgoingEmail (epost_adr, epost_emne, epost_kopi, email_sendt)"
                    + " VALUES (?, ?, ?, ?)");

                } catch (SQLException e){
                e.printStackTrace();
                }

             }

             public int setEpost (String mail, String emne, String kopi, Timestamp timeStamp){

                int result = 0;

                try {
                
                insertEpost.setString(1, mail);
                insertEpost.setString(2, emne);
                insertEpost.setString(3, kopi);
                insertEpost.setTimestamp(4, timeStamp);
                result = insertEpost.executeUpdate();

            }   catch(SQLException e){
                e.printStackTrace();
            }

                return result;
}
}
            %>
            <%
                int result = 0;
                
                if (request.getParameter("send") != null){
                String eMail = new String();
                String nyEmne = new String();
                String nyKopi = new String();
                
                if(request.getParameter("mail") != null){
                    eMail = request.getParameter("mail");
                }
                
                if(request.getParameter("emne") != null){
                    nyEmne = request.getParameter("emne");
                }
                
                if(request.getParameter("kopi") != null){
                    nyKopi = request.getParameter("kopi");
                }
                
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                
                Epost epost = new Epost();
                result = epost.setEpost(eMail, nyEmne, nyKopi, timeStamp);
                }
                %>
        <form name="nyEpost" action="ePost.jsp" method="POST">
             <table border="0">
                <tbody>
                    <tr>
                        <td>Til: </td>
                        <td><input type="text" name="mail" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Emne: </td>
                        <td><input type="text" name="emne" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Kopi: </td>
                        <td><input type="text" name="kopi" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <textarea name="text" rows="10" cols="30">
            </textarea>
            <input type="reset" value="Avbryt" name="avbryt" />
            <input type="submit" value="Send" name="send" />
        </form>
          <div>
        <a href ="index.html"> Home </a>
          </div>
    </body>
</html>
