/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Verktoy.DBVerktoy;
import Verktoy.StudentVerktoy;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import skrivere.StudentSkriver;

/**
 *
 * @author Sondre
 */
@WebServlet(name = "studentSlett", urlPatterns = {"/studentSlett"})
public class studentSlett extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LES</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Fjern student fra klasseliste </h1>");
        
        String listFname; 
        String listLname;     
        String listNoS;
        String valg="";
        
        listNoS = request.getParameter("listNo");
        
        int listNo;
        if (listNoS ==null)
        { listNo =0;
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
            
            conn = dbVerktoy.loggInn2();
            
            if (valg.contains("Fjern"))
                   
                    studentVerktoy.deleteStudent(listFname, listLname, out, conn);
                    
            studentSkriver.slettStudentForm(listNo, listFname, listLname, out); 
           
            out.println("<a href =\"student.html\"> Tilbake </a>");
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