<%-- 
    Document   : ePost
    Created on : 23.okt.2018, 18:34:15
    Author     : Øyvind & Vegard
--%>
<%@page import="java.util.Properties" %> 
<%@page import="javax.mail.*" %>
<%@page import="javax.mail.internet.*" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send ny Gmail</title>
    </head>
    <body onLoad="displayResult()"> 
        
        <h1>Send ny Gmail</h1>
        <%! 
        public class SMTPAuthenticator extends Authenticator {
            public PasswordAuthentication getPasswordAuthentication () {
                return new PasswordAuthentication("team.machine.les", "Root1234");
            }
            
        }

        %>
             
        <%
            
        int resultat = 0;
            
        if(request.getParameter("send") != null) {
            
            String d_uname = "team.machine.les";
            String d_password = "Root1234";
            String d_host = "smtp.gmail.com";
            int d_port = 465;
            
            String m_to = new String();
            String m_from = "team.machine.les@gmail.com";
            String m_subject = new String();
            String m_text = new String();
            
            if (request.getParameter("to") != null) {
                m_to = request.getParameter("to");
            }
            
            if (request.getParameter("subject") != null){
                m_subject = request.getParameter("subject");
            }
            
            if (request.getParameter("message") !=null) {
               
                m_text = m_text.concat(request.getParameter("message"));
              
            }
            
            //create a Properties object
            Properties props = new Properties();
            
            // Create an SMTPAuthenticator object
            
            SMTPAuthenticator auth = new SMTPAuthenticator(); 
            
            //create a mail session object
            Session ses = Session.getInstance(props, auth);
            
            //Create a MIME style email message object
            MimeMessage msg = new MimeMessage(ses);
            msg.setContent(m_text, "text/html");
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(m_from)); 
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            
            try{
                
                Transport transport = ses.getTransport("smtps");
                
                transport.connect(d_host, d_port, d_uname, d_password);
                
                transport.sendMessage(msg, msg.getAllRecipients());
                
                transport.close();
                
                resultat = 1;
            
        } catch (Exception e) {
            out.println(e);
        }
            
        }
        %>
        
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
                    "INSERT INTO outgoingEmail (epost_adr, epost_emne, epost_melding, email_sendt)"
                    + " VALUES (?, ?, ?, ?)");

                } catch (SQLException e){
                e.printStackTrace();
                }

             }

             public int setEpost (String to, String subject, String message, Timestamp timeStamp){

                int result = 0;

                try {
                
                insertEpost.setString(1, to);
                insertEpost.setString(2, subject);
                insertEpost.setString(3, message);
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
                String newSubject = new String();
                String newMessage = new String();
                
                if(request.getParameter("to") != null){
                    eMail = request.getParameter("to");
                }
                
                if(request.getParameter("subject") != null){
                    newSubject = request.getParameter("subject");
                }
                
                if(request.getParameter("message") != null){
                    newMessage = request.getParameter("message");
                }
                
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                
                Epost epost = new Epost();
                result = epost.setEpost(eMail, newSubject, newMessage, timeStamp);
                } 
        %>
        
        <form name="myForm" action="ePost.jsp" method="POST">
            <table border="0">
                <tbody>
                   <tr>
                       <td> To : </td> 
                       <td><input type="text" name="to" value="" sice="50" /></td>
                   </tr>
                   <tr>
                       <td>Subject : </td>
                       <td><input type="text" name="subject" value="" size="50" /></td>
                   </tr>
                   <tr>
                       <td>Message : </td>
                       <td><textarea name="message" rows="4" cols="50"></textarea></td>
                   </tr>
                </tbody>
            </table>
            <input type="hidden" name="hidden" value="<%= resultat %>" />
            <input type="reset" value="clear" name="clear" />
            <input type="submit" value="send" name="send" />
        </form>
            <script language="JavaScript">
                function displayResult(){
                    if (document.myForm.hidden.value === "1") {
                        alert("Gmail sent!"); 
                    }
                }
            </script>
    </body>
</html>