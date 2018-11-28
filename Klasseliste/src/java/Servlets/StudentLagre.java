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
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import skrivere.StudentSkriver;
/**
 * @author Team Machine
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
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>LES</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Legg til eller oppdater en student til Klasseliste </h1>");
            
            String listFname; 
            String listLname; 
            String listEmail;
            String listNoS;
            String valg="";
              
            listNoS = request.getParameter("listNo");
            
            int listNo;
            if (listNoS ==null)
            {   listNo =0;
                listFname = "fornavn";
                listLname = "etternavn";
                listEmail = "e-mail";
            }
            else
            {   listNo = Integer.parseInt(listNoS);
                listFname = request.getParameter("listFname");
                listLname = request.getParameter("listLname");
                listEmail = request.getParameter("listEmail");
                valg = request.getParameter("valg");
            }     
               
            //---------------Konverterer bytes til tekst------------------------  
            byte [] ptext = listFname.getBytes (ISO_8859_1);
            String listFnameFix = new String (ptext,UTF_8); 
            
            byte [] ptext2 = listLname.getBytes (ISO_8859_1);
            String listLnameFix = new String (ptext2,UTF_8); 
            
            byte [] ptext3 = listEmail.getBytes (ISO_8859_1);
            String listEmailFix = new String (ptext3,UTF_8); 
            
            //----------------Skrivere & Verktøy--------------------------------
            StudentSkriver studentSkriver  = new StudentSkriver(); 
            StudentVerktoy studentVerktoy = new StudentVerktoy();  
            
            DBVerktoy dbVerktoy = new DBVerktoy();
             //-----------------------------------------------------------------
            try (Connection conn = dbVerktoy.loggInn2()){
             if (valg.contains("Legg til"))
                   
                    studentVerktoy.newStudent(listFnameFix, listLnameFix, listEmailFix, out, conn);
            studentSkriver.skrivStudentForm(listNo, listFname, listLname, listEmail, out); 
            
            conn.close();
            }catch (Exception ex){
                out.println("Noe gikk galt med å legge til student" + ex);
            }

                
            //out.println("<a href =\"student.html\"> Tilbake </a>");
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

