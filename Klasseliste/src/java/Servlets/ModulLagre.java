package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Verktoy.DBVerktoy;
import Verktoy.ModulVerktoy;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import skrivere.ModulSkriver;

/**
 * @author Knut Andreas Aas // Team Machine
 */
@WebServlet(name = "ModulLagre", urlPatterns = {"/ModulLagre"})
public class ModulLagre extends HttpServlet {
    
    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LES</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Opprett en modul</h1>");
            
            String mName;
            String mDescription; 
            String mResources;
            String mAssignment;
            String mEvaluation;
            String mIds;
            String valg="";
                       
            mIds = request.getParameter("mId");
                       
            int mId;
            if (mIds == null)
            {   mId =0;
                mName = "Navn på modul";
                mDescription = "Beskriv modulen";
                mResources = "Ressurser";
                mAssignment = "Oppgavetekst";
                mEvaluation = "Evaluering";
            }
            else
            {   mId = Integer.parseInt(mIds);
                mName = request.getParameter("mName");
                mDescription = request.getParameter("mDescription");
                mResources = request.getParameter("mResources");
                mAssignment = request.getParameter("mAssignment");
                mEvaluation = request.getParameter("mEvaluation");
                valg = request.getParameter("valg");
            }  
            
            //---------------Konverterer bytes til tekst------------------------  
            byte [] ptext = mName.getBytes (ISO_8859_1);
            String mNameFix = new String (ptext,UTF_8); 
            
            byte [] ptext2 = mDescription.getBytes (ISO_8859_1);
            String mDescriptionFix = new String (ptext2,UTF_8); 
            
            byte [] ptext3 = mResources.getBytes (ISO_8859_1);
            String mResourcesFix = new String (ptext3,UTF_8); 
            
            byte [] ptext4 = mAssignment.getBytes (ISO_8859_1);
            String mAssignmentFix = new String (ptext4,UTF_8);
            
            byte [] ptext5 = mEvaluation.getBytes (ISO_8859_1);
            String mEvaluationFix = new String (ptext5,UTF_8);
            //------------------------------------------------------------------
            
            //---------------Skrivere & Verktøy--------------------------------- 
            ModulSkriver ModulSkriver  = new ModulSkriver(); 
            ModulVerktoy ModulVerktoy = new ModulVerktoy();  
            DBVerktoy dbVerktoy = new DBVerktoy();
            //------------------------------------------------------------------
            
            try (Connection conn = dbVerktoy.loggInn2()){
                
                if (valg.contains("Legg til"))
                    ModulVerktoy.newModule(mId, mNameFix, mDescriptionFix ,mResourcesFix ,mAssignmentFix, mEvaluationFix, out, conn);
                ModulSkriver.skrivModul(mId, mName, mDescription, mResources, mAssignment,mEvaluation, out); 
            }
            
            catch (Exception ex){
                out.println("Noe gikk galt med å lagre modulen" + ex);
            }
     
            //out.println("<a href =\"hentModuler\"> Tilbake </a>");
            out.println("<link href=\"les.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}