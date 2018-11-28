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
   * @param out
   * @param conn 
   */
  public void skrivForum(PrintWriter out, Connection conn)
    { 
        String FORUM  = "<li><a href='ForumDetail?f_id=%s&f_title=%s&f_content=%s'> %s </a></li>\n"; 
         
        PreparedStatement getForums; 
         
         try {
                getForums = conn.prepareStatement("select * from forumlist");
                ResultSet rset = getForums.executeQuery();
                out.println("<h3>Tema:</h3>");
                
                while(rset.next()) {
                    try {
                        String fId = rset.getString("f_id");
                        String fTitle = rset.getString("f_title");
                        String fContent = rset.getString("f_content");
                        
                    out.format(FORUM,fId, fTitle,fContent, fTitle);
                    } catch (SQLException exception) {
                        out.println("Unable to map row" + exception);
                    }
                   
                 }
                rset.close();
                getForums.close();
                conn.close();
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
   */
  public void NyttInnlegg(int fId, String fTitle, String fContent, PrintWriter out, Connection conn) {
        PreparedStatement NyttInnlegg; 
        
        try {
             String ins ="insert into classlist.forumlist (f_title, f_content) values (?, ?)";
          
             NyttInnlegg = conn.prepareStatement(ins);
     
             NyttInnlegg.setString(1,fTitle);             
             NyttInnlegg.setString(2,fContent);  
             
             NyttInnlegg.executeUpdate();     
             
             out.println("Et nytt innlegg har blitt postet!");
                NyttInnlegg.close();
                conn.close();
      }   
         catch (SQLException ex) {
                out.println("Kan ikke opprette et nytt innlegg " +ex);
         }
  }
  public void NyKommentar(String fkTitle, String fkContent, int fId, PrintWriter out, Connection conn) {
      
      PreparedStatement NyKommentar;
        
        String CMT  = "<li><a href='ForumKommentarLagre?f_id=%s'> %s </a></li>\n";      
         try {
             String ins ="insert into classlist.forumkommentar (fk_title, fk_content, f_id) values (?, ?, ?)";

             NyKommentar = conn.prepareStatement(ins);
             
             NyKommentar.setString(1,fkTitle);             
             NyKommentar.setString(2,fkContent);
             NyKommentar.setString(3,CMT);
             NyKommentar.executeUpdate(); 
             
             out.println("En ny kommentar har blitt lagt til!");
                 
                NyKommentar.close();
                conn.close();
        }catch (SQLException ex) {
                out.println("Kan ikke opprette ny kommentar " +ex);
         }
         }
  
  public void skrivForumKommentar(String f_id,PrintWriter out, Connection conn) { 
    String SkrivKommentar = "select forumlist.f_id, forumkommentar.fk_id, forumkommentar.fk_title, forumkommentar.fk_content\n" +
                            "from ((forumdetail\n" + "INNER JOIN forumkommentar ON forumdetail.fk_id = \n" +
                            "forumkommentar.fk_id)\n" +"INNER JOIN forumlist ON forumdetail.f_id =\n" +
                            "forumlist.f_id) where forumlist.f_id = ?";
        
    try (PreparedStatement getKommentarer = conn.prepareStatement(SkrivKommentar)){
         getKommentarer.setString(1,f_id);
         
         try (ResultSet rset = getKommentarer.executeQuery()) {
            while (rset.next()) {
                try {
                    
                    String fkTitle = rset.getString("fk_title");
                    String fkContent = rset.getString("fk_content");
                    
                    out.println("<div class=\"fktitle\">");
                        out.println(fkTitle + "<br></br>");
                        out.println(fkContent); 
                    }     
                catch (SQLException ex) {
                out.println("Ikke hentet fra database " +ex);
                }
            }
                rset.close();
         }catch (SQLException ex) {
                out.println("Ikke hentet fra database " +ex);
    }
                
                getKommentarer.close();
                conn.close();
    } catch (SQLException ex) {
                out.println("Ikke hentet fra database " +ex);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

}