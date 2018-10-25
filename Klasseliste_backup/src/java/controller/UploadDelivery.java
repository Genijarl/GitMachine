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
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UploadDelivery extends HttpServlet {
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        InputStream inputStream = null;
        
        String title=(request.getParameter("title"));
        Part filePart = request.getPart("file_uploaded");
        
        if (filePart != null)
        {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            
            inputStream = filePart.getInputStream();
        }
        
        DBVerktoy dbVerktoy = new DBVerktoy();
        
        try (Connection conn = dbVerktoy.loggInn2(out)){
    
            String sql = "INSERT INTO files (title, f_file) values (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, title);
            
            if (inputStream != null)
                    {
                        statement.setBinaryStream(2, inputStream, (int) filePart.getSize());
                    }
            
            int row = statement.executeUpdate();
            if (row > 0)
            {
                out.println("The file has been uploaded!");
                
                conn.close();
                    }
            else
            {
                out.println("Could'nt upload your file!!");
                
                conn.close();
            }
            
        } catch (SQLException e) {out.println(e);}
        }
    }