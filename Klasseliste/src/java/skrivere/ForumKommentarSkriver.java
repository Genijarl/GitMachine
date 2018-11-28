package skrivere;

import java.io.PrintWriter;

public class ForumKommentarSkriver {
    
    /**
     * @param fkId
     * @param fkTitle
     * @param fkContent
     * @param out 
     */
    public void skrivForumKommentar(int fkId, String fkTitle, String fkContent, PrintWriter out) {
        
        skrivHtmlHeader(out, "");
       
        String DIV ="<div class = '%s'>";
        String FORMs  = "<form action = '%s'  method = POST>";  
        String INP = "<input type='%s' & name='%s' & value='%s'>" +"<br>"; 
        String INPSUB = "<input type='%s' & name='%s' & value='%s'>" +"  ";
        
        out.format(FORMs, "ForumKommentarLagre"); 
               
        // -------------- fkId  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.format(DIV,"inn");
        //Ingen vits i at brukeren kan skrive inn dette
        //Bruker auto increment, ikke nødvendig for bruker å kunne prøve å fylle inn noe her
        out.format(INP, "hidden", "fkId", fkId);
        out.println("</div>");

        // -------------- fkTitle  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.println ("Tittel på kommentar: " +"</div>");       
        out.format(DIV, "inn");
        out.format(INP, "text", "fkTitle", fkTitle);
        out.println("</div>"); 
       
        // ------------- fkContent  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Skriv en kommentar: " +"</div>"); 
        out.format(DIV, "inn");
        out.format(INP, "text", "fkContent", fkContent);
        out.println("</div>"); 
 
        // -------------- Operatorer -------------------------------  
        out.format(DIV, "inn");
        out.format(INPSUB, "Submit","valg", "Publiser");

        out.println("</div>");
        out.println(" <br>");        
        out.println("</form>");  
        out.println("");  
        out.println("</div>");  
      
    }
    
    /**
     * @param out
     * @param tittel 
     */
    public void skrivHtmlHeader(PrintWriter out,  String tittel)
 {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" +tittel +"</title>");  
        out.println("<meta charset=\"UTF-8\">");    
        out.println("<link rel=\"stylesheet\" href=\"css.css\">");
        out.println("<link href=\"les.css\" rel=\"stylesheet\" type=\"text/css\">");
        out.println("</head>");
 }
    /**
     * @param fkTitle
     * @param fkContent
     * @param out 
     */
    public void skrivForumKommentarer(String fkTitle, String fkContent, PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
}