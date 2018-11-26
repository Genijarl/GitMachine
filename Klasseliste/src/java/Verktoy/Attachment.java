package Verktoy;

import java.sql.Blob;

/**
 * @author Jarl Andreassen // Team Machine
 */
public class Attachment {
   
    private int id;
    private String fileName;
    private Blob fileData;
    
    public Attachment (int id, String fileName, Blob fileData) {
        this.id = id;
        this.fileName = fileName;
        this.fileData = fileData;
    }
    
    public int getID() {
        return id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public Blob getFileData() {
        return fileData;
    }
    
    public void setFileData(Blob fileData) {
        this.fileData = fileData;
    }
    
}
