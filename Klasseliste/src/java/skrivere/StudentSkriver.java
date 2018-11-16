package skrivere;

import java.io.PrintWriter;

public class StudentSkriver {
    
 public void skrivStudentForm(int listNo, String listFname, String listLname, PrintWriter out)
    {
        
        skrivHtmlHeader(out, "");
        /*out.println("<h1> Student </h1>");*/
        /*out.println("<h1> En Student </h1>");*/
        
        String DIV ="<div class = '%s'>";
        String FORMs  = "<form action = '%s'  method = POST>";  
        String INP = "<input type='%s' & name='%s' & value='%s'>" +"<br>"; 
        String INPSUB = "<input type='%s' & name='%s' & value='%s'>" +"  ";
        
        out.format(FORMs, "StudentLagre", "studentSlett"); 
               
        // -------------- listNo  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.format(DIV,"inn");
        //Sjekk dette (hidden funker!) Ingen vits i at brukeren kan skrive inn dette (auto increment)
        out.format(INP, "hidden", "listNo", listNo);
        out.println("</div>");

        // -------------- listFname  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.println ("Fornavn: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "listFname", listFname);
        out.println("</div>"); 
        
           
        // ------------- listLname  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Etternavn: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "listLname", listLname);
        out.println("</div>"); 
        
        // -------------- Operatorer -------------------------------
        
         out.format(DIV, "inn");
         
        /*out.format(INPSUB, "Submit", "valg", "Fjern");   */
        out.format(INPSUB, "Submit","valg", "Legg til");
      /* out.format(INPSUB,"Submit", "valg", "Clear"); */

        out.println("</div>");
        
        out.println(" <br>");        
        out.println("</form>");  
        out.println("");  
        out.println("</div>");  
    }
 
  public void slettStudentForm(int listNo, String listFname, String listLname, PrintWriter out)
    {
        
        skrivHtmlHeader(out, "");
        /*out.println("<h1> Student </h1>");*/
        /*out.println("<h1> En Student </h1>");*/
        
        String DIV ="<div class = '%s'>";
        String FORMs  = "<form action = '%s'  method = POST>";  
        String INP = "<input type='%s' & name='%s' & value='%s'>" +"<br>"; 
        String INPSUB = "<input type='%s' & name='%s' & value='%s'>" +"  ";
        
        out.format(FORMs, "studentSlett"); 
               
        // -------------- listNo  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.format(DIV,"inn");
        //Sjekk dette (hidden funker!) Ingen vits i at brukeren kan skrive inn dette (auto increment)
        out.format(INP, "hidden", "listNo", listNo);
        out.println("</div>");

        // -------------- listFname  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.println ("Fornavn: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "listFname", listFname);
        out.println("</div>"); 
        
           
        // ------------- listLname  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Etternavn: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "listLname", listLname);
        out.println("</div>"); 
        
        // -------------- Operatorer -------------------------------
        
         out.format(DIV, "inn");
         
        out.format(INPSUB, "Submit", "valg", "Fjern");   
       /* out.format(INPSUB, "Submit","valg", "Legg til"); */
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

}