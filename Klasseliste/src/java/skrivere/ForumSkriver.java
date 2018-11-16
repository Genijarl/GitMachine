package skrivere;

import java.io.PrintWriter;

public class ForumSkriver {
    
    /**
     * @param fId
     * @param fTitle
     * @param fContent
     * @param out 
     */
    public void skrivForum(int fId, String fTitle, String fContent, PrintWriter out) {
        
        skrivHtmlHeader(out, "");
       
        String DIV ="<div class = '%s'>";
        String FORMs  = "<form action = '%s'  method = POST>";  
        String INP = "<input type='%s' & name='%s' & value='%s'>" +"<br>"; 
        String INPSUB = "<input type='%s' & name='%s' & value='%s'>" +"  ";
        
        out.format(FORMs, "ForumLagre"); 
               
        // -------------- fId  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.format(DIV,"inn");
        //Sjekk dette (hidden funker!) Ingen vits i at brukeren kan skrive inn dette
        //Bruker auto increment, ikke nødvendig for bruker å kunne prøve å fylle inn noe her
        out.format(INP, "hidden", "fId", fId);
        out.println("</div>");

        // -------------- fTitle  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.println ("Tittel på innlegg: " +"</div>");       
        out.format(DIV, "inn");
        out.format(INP, "text", "fTitle", fTitle);
        out.println("</div>"); 
       
        // ------------- fContent  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Skriv et innlegg: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "fContent", fContent);
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
     * @param fTitle
     * @param fContent
     * @param out 
     */
    public void skrivForum(String fTitle, String fContent, PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
}