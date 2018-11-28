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
  
  /**
   * @param out
   * @param conn 
   */  
  public void skrivModul(PrintWriter out, Connection conn)
    { 
        String MODULE  = "<li><a href='ModuleDetail?m_id=%s&m_name=%s&m_description=%s&m_resources=%s&m_assignment=%s&m_evaluation=%s'> %s</a></li>\n"; 
         
        PreparedStatement getModules; 
         
         try {
                getModules = conn.prepareStatement("select * from modulelist");
                
                ResultSet rset = getModules.executeQuery();

                out.println("Moduler:" +"<br>");
                
                while(rset.next()) {
                    try {
                        String mId = rset.getString("m_id");
                        String mName = rset.getString("m_name");
                        String mDescription = rset.getString("m_description");
                        String mResources = rset.getString("m_resources");
                        String mAssignment = rset.getString("m_assignment");
                        String mEvaluation = rset.getString("m_evaluation");
          
                    out.format(MODULE,mId, mName,mDescription, mResources, mAssignment, mEvaluation, mName);        
                   
                    } catch (SQLException exception) {
                        out.println("Unable to map row" + exception);
                    }
                    
                 }
                getModules.close();
                rset.close();
                conn.close();
         }     
        catch (SQLException ex) {
                out.println("Ikke hentet fra database " +ex);
         }
         
   }
  
  /**
   * @param mName
   * @param mDescription
   * @param mResources
   * @param mAssignment
   * @param mEvaluation
   * @param out
   * @param conn 
   */
  public void newModule(String mName,String mDescription,String mResources,String mAssignment,String mEvaluation, PrintWriter out, Connection conn) {
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
             
             newModule.close();
             conn.close();
        }    
        catch (SQLException ex) {
               out.println("Can`t create new module " +ex);
        }
  }


  public void deleteModul(String mName, PrintWriter out, Connection conn) {
        PreparedStatement deleteModul;
        out.println("Modulen ble slettet!!");
        try {
             String ins = "DELETE FROM classlist.modulelist WHERE ( m_name) = (?)";
          
             deleteModul = conn.prepareStatement(ins);
          
             deleteModul.setString(1, mName);             
             
           
             deleteModul.executeUpdate();
           
             deleteModul.close();
             conn.close();
  } catch(SQLException ex) {
          out.println("Sletting av modul feilet " + ex);
          }
  }
}
  