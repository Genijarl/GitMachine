package Servlets;

import Verktoy.DBVerktoy;
import Verktoy.ModulVerktoy;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import skrivere.ModulSkriver;

/**
 *
 * @author Sondre Lømsland // Team Machine
 */
@WebServlet(name = "modulSlett", urlPatterns = {"/modulSlett"})
public class ModulSlett extends HttpServlet {

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
            out.println("<h1>Fjern en modul </h1>");
        
            String mName;
            String mIds;
            String valg="";
        
            mIds = request.getParameter("mId");
        
            int mId;
            if (mIds ==null)
            {   mId =0;
                mName = "Navn";
                
            } 
            else
            {   mId = Integer.parseInt(mIds);
                mName = request.getParameter("mName");
                valg = request.getParameter("valg");
            }
        
            ModulSkriver modulSkriver  = new ModulSkriver(); 
            ModulVerktoy modulVerktoy = new ModulVerktoy();  
        
            DBVerktoy dbVerktoy = new DBVerktoy();
            
            try {
            Connection conn; 
            conn = dbVerktoy.loggInn2();
            
            if (valg.contains("Fjern"))
                   
                    modulVerktoy.deleteModul(mName, out, conn);
                    
            modulSkriver.slettModulForm(mId, mName, out); 
            
           conn.close();
            }catch (Exception ex){
                out.println("Noe gikk galt" + ex);
            }
            //out.println("<a href =\"moduler.html\"> Tilbake </a>");
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