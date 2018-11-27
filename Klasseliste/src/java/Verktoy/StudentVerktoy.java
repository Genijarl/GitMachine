package Verktoy;


import java.io.PrintWriter;
import java.sql.*; 

/**
 * @author Jarl Andreassen & Sondre LømslandTeam Machine
 */
public class StudentVerktoy {
    Connection conn;     
    Statement stmt;
    
    PreparedStatement insertStudent; 
    
  /**
   * @param out
   * @param conn 
   */   
  public void skrivStudenter(PrintWriter out, Connection conn)
    { 
        String STUDENT  = "<li><a href='StudentDetail?list_no=%s&list_fname=%s&list_lname=%s&list_email=%s'>%s %s %s</a></li>\n"; 
            
        PreparedStatement getStudents;
         
         try {
                getStudents = conn.prepareStatement("select * from clist");
                
                ResultSet rset = getStudents.executeQuery();
 
                out.println("Studenter i klasselisten:" +"<br>");
                int rowCount = 0;
                while(rset.next()) { 
                    try {    
                    String listNo = rset.getString("list_no");
                    String listFname = rset.getString("list_fname");
                    String listLname = rset.getString("list_lname");
                    String listEmail = rset.getString("list_email");
                   
                    out.format(STUDENT,listNo, listFname, listLname, listEmail, listNo, listLname, listFname);
                                      
                    ++rowCount;
                    } catch (SQLException exception) {
                        out.println("Unable to map row" + exception);
                    }
                 } 
                 out.println("<br></br>");
                 out.println("Totalt antall studenter = " + rowCount);    
         }     
         catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
         }
   }
  
  /**
   * @param listFname
   * @param listLname
   * @param listEmail
   * @param out
   * @param conn 
   */
  public void newStudent(String listFname, String listLname, String listEmail, PrintWriter out, Connection conn) {
        PreparedStatement newStudent; 
        out.println("Studenten "+ listFname + " "+ listLname + " ble lagt til! ");
         try {
             String ins ="insert into classlist.clist (list_fname, list_lname, list_email)  values (?, ?, ?)";
          
             newStudent = conn.prepareStatement(ins);
     
             newStudent.setString(1,listFname);             
             newStudent.setString(2,listLname);  
             newStudent.setString(3,listEmail);
                
             newStudent.executeUpdate();     
             } 
         catch (SQLException ex) {
                out.println("Ikke fått opprettet NY Student " +ex);
         }
  }
  
  /**
   * @param listFname
   * @param listLname
   * @param out
   * @param conn 
   */
  public void deleteStudent(String listFname, String listLname, PrintWriter out, Connection conn) {
        PreparedStatement deleteStudent;
        out.println("Studenten ble slettet!");
        try {
             String ins = "DELETE FROM classlist.clist WHERE ( list_fname, list_lname) = (?, ?)";
          
             deleteStudent = conn.prepareStatement(ins);
          
             deleteStudent.setString(1,listFname);             
             deleteStudent.setString(2,listLname);  
           
             deleteStudent.executeUpdate();
           
  } catch(SQLException ex) {
          out.println("Sletting av student feilet " + ex);
          }
}
}