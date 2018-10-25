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
import skrivere.ModulSkriver;


/**
 *
 * @author Knut Andreas Aas
 */
@WebServlet(name = "ModulLagre", urlPatterns = {"/ModulLagre"})
public class ModulLagre extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ny modul</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Legg til eller oppdater en modul</h1>");
            
            
            String mName;
            String mDescription; 
            String mResources;
            String mAssignment;
            String mIds;
            String valg="";
            
            mIds = request.getParameter("mId");
              
          
            int mId = 0;
            if (mIds == null)
            {   mId =0;
                mName = "Name";
                mDescription = "Description";
                mResources = "Resources";
                mAssignment = "Assignment";
            }
            else
                { 
                mId = Integer.parseInt(mIds);
                mName = request.getParameter("mName");
                mDescription = request.getParameter("mDescription");
                mResources = request.getParameter("mResources");
                mAssignment = request.getParameter("mAssignment");
                }     
               
            ModulSkriver ModulSkriver  = new ModulSkriver(); 
            ModulVerktoy ModulVerktoy = new ModulVerktoy();  

            
            DBVerktoy dbVerktoy = new DBVerktoy();
            Connection conn; 
            
            conn = dbVerktoy.loggInn2(out);
            
            if (valg.contains("Legg til"))
                   
                    ModulVerktoy.newModule(mId, mName, mDescription,mResources,mAssignment, out, conn);
                    
            ModulSkriver.skrivModul(mId, mName, mDescription, mResources, mAssignment, out); 
           
            
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
