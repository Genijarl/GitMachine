package skrivere;

import java.io.PrintWriter;

/**
 * @author Jarl Andreassen & Sondre Lømsland // Team Machine
 */
public class StudentSkriver {
  
 /**     
  * @param listNo
  * @param listFname
  * @param listLname
  * @param listEmail
  * @param out 
  */   
 public void skrivStudentForm(int listNo, String listFname, String listLname, String listEmail, PrintWriter out)
    {
                
        skrivHtmlHeader(out, "");
        
        String DIV ="<div class = '%s'>";
        String FORMs  = "<form action = '%s'  method = POST>";  
        String INP = "<input type='%s' & name='%s' & value='%s'>" +"<br>"; 
        String INPSUB = "<input type='%s' & name='%s' & value='%s'>" +"  ";
        
        out.format(FORMs, "StudentLagre"); 
               
        // -------------- listNo  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.format(DIV,"inn");
        //Ingen vits i at brukeren kan skrive inn dette (auto increment)
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
        
        // ------------- listEmail ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("E-mail: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "email", "listEmail", listEmail);
        out.println("</div>"); 
        
        
        // -------------- Operatorer -------------------------------
        out.format(DIV, "inn");
        out.format(INPSUB, "Submit","valg", "Legg til");

        out.println("</div>");
        out.println(" <br>");        
        out.println("</form>");  
        out.println("");  
        out.println("</div>");  
    }
 
  public void slettStudentForm(int listNo, String listFname, String listLname, PrintWriter out)
    {
        skrivHtmlHeader(out, "");

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