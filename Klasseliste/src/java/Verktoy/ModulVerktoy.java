package Verktoy;


import java.io.PrintWriter;
import java.sql.*; 

/**
 * @author Knut Andreas Aas // Team Machine
 */

public class ModulVerktoy {
    Connection conn;
    Statement stmt;
    PreparedStatement insertModul; 
     
  public void skrivModul(PrintWriter out, Connection conn)
    { 
        String MODULE  = "<li><a href='ModuleDetail?m_id=%s&m_name=%s&m_description=%s&m_resources=%s&m_assignment=%s&m_evaluation=%s'> %s</a></li>\n"; 
         
        PreparedStatement getModules; 
         
         try {
                getModules = conn.prepareStatement("select * from modulelist");
               /* getModules.setString(1,"mName");*/
                
                ResultSet rset = getModules.executeQuery();
 
                // Step 4: Process the ResultSet by scrolling the cursor forward via next().
                //  For each row, retrieve the contents of the cells with getXxx(columnName).
                out.println("Moduler:" +"<br>");
                
                int rowCount = 0;
                while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                    try {
                        String mId = rset.getString("m_id");
                        String mName = rset.getString("m_name");
                        String mDescription = rset.getString("m_description");
                        String mResources = rset.getString("m_resources");
                        String mAssignment = rset.getString("m_assignment");
                        String mEvaluation = rset.getString("m_evaluation");
          
                    out.format(MODULE,mId, mName,mDescription, mResources, mAssignment, mEvaluation, mName);
                                      
                    ++rowCount;
                    } catch (SQLException exception) {
                        out.println("Unable to map row" + exception);
                    }
                 }
         }     
        catch (SQLException ex) {
                out.println("Ikke hentet fra database " +ex);
         }
   }

  
  public void newModule(int mId, String mName,String mDescription,String mResources,String mAssignment,String mEvaluation, PrintWriter out, Connection conn) {
        PreparedStatement newModule; 
        out.println("En ny modul har blitt lagt til!");
        
        try {
             String ins ="insert into classlist.modulelist (m_name, m_description, m_resources, m_assignment, m_evaluation) values ( ?, ?, ?, ?, ?)";
          
             newModule = conn.prepareStatement(ins);
     
             newModule.setString(1,mName);             
             newModule.setString(2,mDescription);  
             newModule.setString(3,mResources);
             newModule.setString(4,mAssignment);
             newModule.setString(5,mEvaluation);
             
             newModule.executeUpdate();
             
      } // end try     
         catch (SQLException ex) {
                out.println("Can`t create new module " +ex);
         }
  }
}