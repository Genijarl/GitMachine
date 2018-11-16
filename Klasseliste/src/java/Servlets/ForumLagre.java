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
import Verktoy.ForumVerktoy;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import skrivere.ForumSkriver;


/**
 *
 * @author Knut Andreas Aas
 */
@WebServlet(name = "ForumLagre", urlPatterns = {"/ForumLagre"})
public class ForumLagre extends HttpServlet {
    
    
    /**Jeg valgte å gjøre det sånn fordi...*/
    
    /**
     * 
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
            out.println("<h2> Publiser et innlegg </h2>");
            
            String fTitle;
            String fContent;
            String fIds;
            String valg="";
                       
            fIds = request.getParameter("fId");
                       
            int fId;
            if (fIds == null)
            {   fId =0;
                fTitle = "Tittel på innlegg";
                fContent = "Still et spørmål";  
            }
            else
                { 
                fId = Integer.parseInt(fIds);
                fTitle = request.getParameter("fTitle");
                fContent = request.getParameter("fContent");
                valg = request.getParameter("valg"); 
                }   
            
            //Konverterer bytes til tekst  
            byte [] ptext = fTitle.getBytes (ISO_8859_1);
            String fTitleFix = new String (ptext,UTF_8); 
            
            byte [] ptext2 = fContent.getBytes (ISO_8859_1);
            String fContentFix = new String (ptext2,UTF_8); 
            
            
            ForumSkriver ForumSkriver  = new ForumSkriver(); 
            ForumVerktoy ForumVerktoy = new ForumVerktoy();  
            DBVerktoy dbVerktoy = new DBVerktoy();
           
            
            try (Connection conn = dbVerktoy.loggInn2()){
                
                if (valg.contains("Publiser"))
                   
                    ForumVerktoy.NyttInnlegg(fId, fTitleFix, fContentFix, out, conn);
                ForumSkriver.skrivForum(fId, fTitle, fContent, out);         
            }
            
            catch (Exception ex){
                out.println("Noe gikk galt med å poste innlegget " + ex);
            }
            
            out.println("<a href =\"forum.html\"> Tilbake </a>");
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