package Servlets;

import Verktoy.Attachment;
import Verktoy.DBVerktoy;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jarl Andreassen // Team Machine
 */
@WebServlet(name = "fileView", urlPatterns = {"/fileView"})
public class FilNedlastning extends HttpServlet {

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        DBVerktoy dbVerktoy = new DBVerktoy();
        try (Connection conn = dbVerktoy.loggInn2()){
        
            int id = 0;
            try{
                id = Integer.parseInt(request.getParameter("id"));
            } catch (Exception e) {
            }
            Attachment attachment = getAttachmentFromDB(id, conn);
            
            if (attachment == null) {
                response.getWriter().write("No data found!");
                return;
            }
           
            String fileName = attachment.getFileName();
            System.out.println("File name: " + fileName);
            
            String contentType = this.getServletContext().getMimeType(fileName);
                System.out.println("Content type: " + contentType);
                
                response.setHeader("Content-Type", contentType);
                response.setHeader("Content-Length", String.valueOf(attachment.getFileData().length()));
                response.setHeader("Content-Disposition", "attachment; filename=\"" + attachment.getFileName() + "\"");
                
                Blob fileData = attachment.getFileData();
                InputStream is = fileData.getBinaryStream();
                
                byte[] bytes = new byte[1024];
                int bytesRead;
                
                while ((bytesRead = is.read(bytes)) != -1) {
                    response.getOutputStream().write(bytes, 0, bytesRead);
                }
                is.close();
                
            } catch (Exception e) {
                throw new ServletException(e);
            }

    }
    
    private Attachment getAttachmentFromDB(int id, Connection conn) throws SQLException {
        String sql = "SELECT f_file, title FROM files WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            Blob fileData = rs.getBlob("f_file");
            String fileName = rs.getString("title");
            return new Attachment(id, fileName, fileData);
        }
        return null;
        }
    }