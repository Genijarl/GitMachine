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
import Verktoy.StudentVerktoy;

@WebServlet(name = "StudentDetail", urlPatterns = {"/StudentDetail"})
public class StudentDetail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentDetail</title>");            
            out.println("</head>");
            out.println("<body>"); 
            
            String listFname= request.getParameter("list_fname");
            String listLname = request.getParameter("list_lname");
           
            
            out.println("<h1>Student detaljer</h1>");
         
            out.println("Fornavn " + listFname + "Etternavn " + listLname);
                      
            
            StudentVerktoy StudentVerktoy = new StudentVerktoy();
            DBVerktoy dbVerktoy = new DBVerktoy();
            
            Connection conn; 
            conn = dbVerktoy.loggInn2(out);
            
            //Brukes denne kommer alle modulene i modul beskrivelsen
            /*ModulVerktoy.skrivModul(out,conn);*/
                        
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
