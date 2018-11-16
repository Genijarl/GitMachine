package Verktoy;

import java.io.PrintWriter;
import java.sql.*; 

/**
 * @author Knut Andreas Aas // Team Machine
 */

public class ForumVerktoy {
    Connection conn;
    Statement stmt;
    PreparedStatement insertInnlegg; 
     
  /**
   * 
   * @param out
   * @param conn 
   * @author Knut Andreas Aas
   */ 
  public void skrivForum(PrintWriter out, Connection conn)
    { 
        String FORUM  = "<li><a href='ForumDetail?f_id=%s&f_title=%s&f_content=%s'> %s </a></li>\n"; 
         
        PreparedStatement getForums; 
         
         try {
                getForums = conn.prepareStatement("select * from forumlist");
                ResultSet rset = getForums.executeQuery();
                out.println("<h3>Tema:</h3>");
                
                int rowCount = 0;
                while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                    try {
                        String fId = rset.getString("f_id");
                        String fTitle = rset.getString("f_title");
                        String fContent = rset.getString("f_content");
                        
          
                    out.format(FORUM,fId, fTitle,fContent, fTitle);
                                      
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

  /**
   * @param fId
   * @param fTitle
   * @param fContent
   * @param out
   * @param conn 
   * @author Knut Andreas Aas
   */
  public void NyttInnlegg(int fId, String fTitle, String fContent, PrintWriter out, Connection conn) {
        PreparedStatement NyttInnlegg; 
        out.println("Et nytt innlegg har blitt postet!");
        
        try {
             String ins ="insert into classlist.forumlist (f_title, f_content) values (?, ?)";
          
             NyttInnlegg = conn.prepareStatement(ins);
     
             NyttInnlegg.setString(1,fTitle);             
             NyttInnlegg.setString(2,fContent);  
             
             //out.println(NyttInnlegg);
             NyttInnlegg.executeUpdate();     
             
      } // end try     
         catch (SQLException ex) {
                out.println("Kan ikke opprette et nytt innlegg " +ex);
         }
  }
    /**
     * @param fTitleFix
     * @param fContentFix
     * @param out
     * @param conn 
     * @author Knut Andreas Aas
     */
    public void NyttInnlegg(String fTitleFix, String fContentFix, PrintWriter out, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}