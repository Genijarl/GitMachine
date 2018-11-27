package skrivere;

import java.io.PrintWriter;

/**
 * @author Knut Andreas Aas // Team Machine
 */
    public class ModulSkriver {
        
    /**
     * @param mId
     * @param mName
     * @param mDescription
     * @param mResources
     * @param mAssignment
     * @param mEvaluation
     * @param out 
     */
    public void skrivModul(int mId, String mName, String mDescription, String mResources, String mAssignment, String mEvaluation, PrintWriter out) {
        
        skrivHtmlHeader(out, "");
       
        String DIV ="<div class = '%s'>";
        String FORMs  = "<form action = '%s'  method = POST>";  
        String INP = "<input type='%s' & name='%s' & value='%s' & input style='%s'>" +"<br>"; 
        String INPD = "<textarea & name='%s' & value='%s' & input style='%s'></textarea>" +"<br>"; 
        String INPSUB = "<input type='%s' & name='%s' & value='%s'>" +"  ";
        
        out.format(FORMs, "ModulLagre"); 
               
        // -------------- mId  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.format(DIV,"inn");
        //Ingen vits i at brukeren kan skrive inn dette
        //Bruker auto increment, ikke nødvendig for bruker å kunne prøve å fylle inn noe her
        out.format(INP, "hidden", "mId", mId, "width:500px;");
        out.println("</div>");

        // -------------- mName  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.println ("Modul navn: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "mName", mName, "width:500px;");
        out.println("</div>"); 
       
        // ------------- mDescription  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Beskrivelse: " +"</div>");
        
        out.format(DIV, "inn");
        out.format (INPD, "mDescription", mDescription, "width:500px;height:200px;");
        out.println("</div>"); 
        
        // ------------- mResources  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Ressurser: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INPD, "mResources", mResources, "width:500px;height;100px;");
        out.println("</div>"); 
        
        // ------------- mAssignment  ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Oppgave: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INPD, "mAssignment", mAssignment, "width:500px;height;100px;");
        out.println("</div>"); 
        
        // ------------- mEvaluation ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Evaluering: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "mEvaluation", mEvaluation, "width:500px;");
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
        out.println("<link href=\"les.css\" rel=\"stylesheet\" type=\"text/css\">");
        out.println("</head>");
 }

    /**
     * @param mName
     * @param mDescription
     * @param mResources
     * @param mAssignment
     * @param mEvaluation
     * @param out 
     */
    public void skrivModul(String mName, String mDescription, String mResources, String mAssignment, String mEvaluation, PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}