package Verktoy;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Team Machine
 */
public class DBVerktoy {
    Connection conn; 
    Statement stmt;
        
        public Connection loggInn2() {
        try {
         Context cont = new InitialContext();
         DataSource ds = (DataSource)cont.lookup("java:comp/env/jdbc/classlist");  
         conn =  ds.getConnection();
         stmt = conn.createStatement();
        }
        catch (SQLException ex ) {
            System.out.println("Not connected to database " +ex);
        }
        catch (NamingException nex) {
            System.out.println("Not correct naming" + nex);
        }
       return conn; 
    }

    public Connection loggInn2(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}    
    