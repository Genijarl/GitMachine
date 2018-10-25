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
import skrivere.StudentSkriver;

/**
 *
 * @author Knut Andreas Aas
 */
@WebServlet(name = "StudentLagre", urlPatterns = {"/StudentLagre"})
public class StudentLagre extends HttpServlet {
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
            out.println("<title>Ny student</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Legg til eller oppdater en student til Klasseliste </h1>");
            
            
            String listFname; 
            String listLname; 
            String listNoS;
            String valg="";
              
            listNoS = request.getParameter("listNo");
            
            int listNo;
            if (listNoS ==null)
            {   listNo =0;
                listFname = "fornavn";
                listLname = "etternavn";
            }
            else
                {
                listNo = Integer.parseInt(listNoS);
                listFname = request.getParameter("listFname");
                listLname = request.getParameter("listLname");
                valg = request.getParameter("valg");
                }     
               
            StudentSkriver studentSkriver  = new StudentSkriver(); 
            StudentVerktoy studentVerktoy = new StudentVerktoy();  

            
            DBVerktoy dbVerktoy = new DBVerktoy();
            Connection conn; 
            
            conn = dbVerktoy.loggInn2(out);
            
            if (valg.contains("Legg til"))
                   
                    studentVerktoy.newStudent(listFname, listLname, out, conn);
                    
            studentSkriver.skrivStudentForm(listNo, listFname, listLname, out); 
           
            
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

