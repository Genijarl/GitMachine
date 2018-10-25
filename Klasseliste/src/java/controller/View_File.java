package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import Verktoy.DBVerktoy;
import com.mysql.jdbc.Blob;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Jarl
 */
@WebServlet("/viewFile")
@MultipartConfig(maxFileSize = 16177215)

public class View_File extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            String id=(request.getParameter("id"));
            
            Blob file = null;
            byte[ ] fileData = null ;

           DBVerktoy dbVerktoy = new DBVerktoy();
        
        try (Connection conn = dbVerktoy.loggInn2(out)){
            
                String sqlString = "SELECT f_file FROM files WHERE id = '"+id+"'";
                Statement myStatement = conn.createStatement();
                
                
                ResultSet rs=myStatement.executeQuery(sqlString);
                
                if (rs.next()) 
                {
                    file = (Blob) rs.getBlob("f_file");
                    fileData = file.getBytes(1,(int)file.length());
                } else 
                {
                    out.println("file not found!");
                    return;
                }
                
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "inline");
                response.setContentLength(fileData.length);
                
                OutputStream output = response.getOutputStream();
                output.write(fileData);
                
                output.flush();
                
            } catch (SQLException e) {out.println(e);}
}
}