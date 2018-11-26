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

/**
 * @author Knut Andreas Aas // Team Machine
 */
@WebServlet(name = "ModuleDetail", urlPatterns = {"/ModuleDetail"})
public class ModulDetailjer extends HttpServlet {
    
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
            
            String mName  = request.getParameter("m_name");
            String mDescription = request.getParameter("m_description");
            String mResources = request.getParameter("m_resources");
            String mAssignment = request.getParameter("m_assignment");
            String mEvaluation = request.getParameter("m_evaluation");
            
            out.println("<h1>Modul detaljer</h1>");
            out.println(mName);
            out.print("<br></br>");
            out.println("Beskrivelse: " + ("<br></br>") + mDescription);
            out.print("<br></br>");
            out.println("Ressurser: " +("<br></br>")+ mResources);
            out.print("<br></br>");
            out.println("Oppgave: " + ("<br></br>") +mAssignment);
            out.print("<br></br>");
            out.println("Evaluering: " + ("<br></br>") +mEvaluation);
                      
            DBVerktoy dbVerktoy = new DBVerktoy();
            
            Connection conn; 
            conn = dbVerktoy.loggInn2();
            
            out.println("<br></br>");            
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