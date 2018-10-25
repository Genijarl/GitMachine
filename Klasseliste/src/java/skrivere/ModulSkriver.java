package skrivere;

import java.io.PrintWriter;

public class ModulSkriver {
    
 public void skrivModul(int mId, String mName, String mDescription, String mResources, String mAssignment, PrintWriter out)
    {
        
        skrivHtmlHeader(out, "");
        /*out.println("<h1> Student </h1>");*/
        /*out.println("<h1> En Student </h1>");*/
        
        String DIV ="<div class = '%s'>";
        String FORMs  = "<form action = '%s'  method = POST>";  
        String INP = "<input type='%s' & name='%s' & value='%s'>" +"<br>"; 
        String INPSUB = "<input type='%s' & name='%s' & value='%s'>" +"  ";
        
        out.format(FORMs, "ModulLagre"); 
               
        // -------------- mId  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.format(DIV,"inn");
        //Sjekk dette (hidden funker!) Ingen vits i at brukeren kan skrive inn dette
        out.format(INP, "hidden", "mId", mId);
        out.println("</div>");

        // -------------- mName  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.println ("Modul navn: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "mName", mName);
        out.println("</div>"); 
        
           
        // ------------- mDescription  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Beskrivelse: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "mDescription", mDescription);
        out.println("</div>"); 
        
         // ------------- mResources  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Ressurser: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "mResources", mResources);
        out.println("</div>"); 
        
           // ------------- mAssignment  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Oppgave: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "mAssignment", mAssignment);
        out.println("</div>"); 
        
        // -------------- Operatorer -------------------------------
        
         out.format(DIV, "inn");
         
      /*  out.format(INPSUB, "Submit", "valg", "Oppdater");   // type navn ledetekst */
        out.format(INPSUB, "Submit","valg", "Legg til");
      /* out.format(INPSUB,"Submit", "valg", "Clear"); */

        out.println("</div>");
        
        out.println(" <br>");        
        out.println("</form>");  
        out.println("");  
        out.println("</div>");  
    }
    
    public void skrivHtmlHeader(PrintWriter out,  String tittel)
 {
      out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>" +tittel +"</title>");  
       out.println("<meta charset=\"UTF-8\">");    
       out.println("<link rel=\"stylesheet\" href=\"css.css\">");
            
       out.println("</head>");
 }

    public void skrivModule(String mName, String mDescription, String mResources, String mAssignment, PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}

    
    

