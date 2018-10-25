package Verktoy;


import java.io.PrintWriter;
import java.sql.*; 

/**
 * @author Knut Andreas Aas
 */

public class ModulVerktoy {
    Connection conn;
    Statement stmt;
    
    PreparedStatement insertModule; 
     
  public void skrivModul(PrintWriter out, Connection conn)
    { 
        String MODULE  = "<li><a href='ModuleDetail?m_id=%s&m_name=%s&m_description=%s&m_resources=%s&m_assignment=%s'> %s</a></li>\n"; 
         
        PreparedStatement getModules; 
         
         try {
                getModules = conn.prepareStatement("select * from modulelist");
               /* getModules.setString(1,"mName");*/
                
                ResultSet rset = getModules.executeQuery();
 
                // Step 4: Process the ResultSet by scrolling the cursor forward via next().
                //  For each row, retrieve the contents of the cells with getXxx(columnName).
                out.println("Modules:" +"<br>");
                int rowCount = 0;
                while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                    try {
                    int mId = rset.getInt("m_id");
                    String mName = rset.getString("m_name");
                    String mDescription = rset.getString("m_description");
                    String mResources = rset.getString("m_resources");
                    String mAssignment = rset.getString("m_assignment");
                    /*out.println(mId + " , " + mName + ", " + mDescription +", " + mResources +", " + mAssingment +"<br>");*/
                    out.format(MODULE,mId, mName,mDescription, mResources, mAssignment, mName);
                                      
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

  
  public void newModule(int mId, String mName,String mDescription,String mResources,String mAssignment, PrintWriter out, Connection conn) {
        PreparedStatement newModule; 
        out.println("Inni newModule");
         try {
             String ins ="insert into classlist.modulelist (m_name, m_description, m_resources, m_assignment, values (?, ?)";
          
             newModule = conn.prepareStatement(ins);
     
             newModule.setString(1,mName);             
             newModule.setString(2,mDescription);  
             newModule.setString(3,mResources);
             newModule.setString(4,mAssignment);
                
             out.println(newModule);
             newModule.executeUpdate();
             
      } // end try     
         catch (SQLException ex) {
                out.println("Can`t create new module " +ex);
         }
  }

    public void skrivModulErr(PrintWriter out, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
    

