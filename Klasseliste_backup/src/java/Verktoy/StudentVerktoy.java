/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verktoy;


import java.io.PrintWriter;
import java.sql.*; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author hallgeir
 */
public class StudentVerktoy {
    Connection conn;        // Must be defined here as class variables, get their value in the login method
    Statement stmt;
    
    PreparedStatement insertStudent; 
    
     
  public void skrivStudenter(PrintWriter out, Connection conn)
    { 
        String STUDENT  = "<li><a href='StudentDetail?list_no=%s&list_fname=%s&list_lname=%s'>%s %s %s</a></li>\n"; 
         
        PreparedStatement getStudents; 
         
         try {
                getStudents = conn.prepareStatement("select * from clist");
               /* getStudents.setString(1,"list_fname");*/
                
                ResultSet rset = getStudents.executeQuery();
 
                // Step 4: Process the ResultSet by scrolling the cursor forward via next().
                //  For each row, retrieve the contents of the cells with getXxx(columnName).
                out.println("Studenter i klasselisten:" +"<br>");
                int rowCount = 0;
                while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                    try {
                    String listNo = rset.getString("list_no");
                    String listFname = rset.getString("list_fname");
                    String listLname = rset.getString("list_lname");
                    /*out.println(listNo + " , " + listFname + ", " + listLname +"<br>");*/
                    out.format(STUDENT,listNo, listFname,listLname, listNo, listLname,listFname);
                                      
                    ++rowCount;
                    } catch (SQLException exception) {
                        out.println("Unable to map row" + exception);
                    }
                 }  // end while
                 out.println("Totalt antall studenter = " + rowCount);
                 
                  //out.format(STUDENT,0,"","", -1,"new","new");
                 
         } // end try     
         catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
         }
   }

  
  public void newStudent(String listFname, String listLname, PrintWriter out, Connection conn) {
        PreparedStatement newStudent; 
        out.println("Inni newStudent");
         try {
             String ins ="insert into classlist.clist ( list_fname,list_lname)  values (?, ?)";
          
             newStudent = conn.prepareStatement(ins);
     
            // newStudent.setInt(1,listNo);
             newStudent.setString(1,listFname);             
             newStudent.setString(2,listLname);  
                
             out.println(newStudent);
             newStudent.executeUpdate();
             
      } // end try     
         catch (SQLException ex) {
                out.println("Ikke fått opprettet NY Student " +ex);
         }
  }


}
    
