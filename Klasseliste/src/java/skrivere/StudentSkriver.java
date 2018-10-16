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
        
        out.format(FORMs, "StudentLagre"); 
               
        // -------------- listNo  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.println("Studentnummer: "+"</div>");
        out.format(DIV,"inn");
        out.format(INP, "text", "listNo", listNo);
        out.println("</div>");

        // -------------- listFname  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.println ("Fornavn: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "listFname", listFname);
        out.println("</div>"); 
        
           
        // ------------- litLname  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Etternavn: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "listLname", listLname);
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
 
    
    /*
 public void skrivStudentFormOld(int listNo, PrintWriter out)
    {
        skrivHtmlHeader(out, "UiA-Studenter");
        out.println("<h1> Student </h1>");
        String fn = "\"";
        out.println("<div class= "+fn +"form" +fn +">");
        
        out.println("<h1> En Student </h1>");
        out.println("<form action= "+fn +"StudentLagre" +fn +"method=" +fn +"post" +fn +">");
        out.println("<div class = \"ledetekst\"> Tall1: </div>");
        

        //skriver ut ett input felt, angir først div, har og med value. 
        out.println("<div class = \"inn\"> <input type=\"text\" name = \"tall1\" value = \"");
           out.println(listNo);
           out.println("\"> </div>"); 
        
           
        // --------------Tall2 ------------------------------- 
        out.println("<div class = \"ledetekst\"> Tall2 </div>");
        out.println("<div class = \"inn\"> <input type=\"text\" name = \"tall2\" value = \"");  
        out.println(listNo);
        out.println("\"> </div> <br><br>");
        
           
         out.println("<div class = \"ledetekst\"> Resultat </div>");
           out.println("<div class = \"inn\"> <input type=\"text\" name = \"resultat\" value = \"");  
           out.println(listNo);
           out.println("\"> </div>");   
        
        out.println("<div class = \"ledetekst\"> Operator </div>");
        out.println("<br>");
        out.println("<div class = \"inn\">");

        
        out.println("<input type=\"Submit\" name=\"oppdater\" value=\"Oppdater\" "
               +"\">");        
        
        out.println("<input type=\"Submit\" name=\"ny\" value=\"Legg til\""
                  +"\">" );        
        
        out.println("  <input type=\"Submit\" name=\"Clear\" value=\"Clear\">  ");        
        out.println("</div>");  

        out.println(" <br>");        
        out.println("</form>");  
        out.println("");  
        out.println("</div>");  
    }
 */
}

    
    

