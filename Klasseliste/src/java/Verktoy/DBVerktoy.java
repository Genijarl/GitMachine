
/*
 * In this version we do all that has to do with the database connection here.
 * No changes in tomee.xml or context.xml
 * New here is use of Prepared Statement 
 */
package Verktoy;

import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.*; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author hallgeir
 */
public class DBVerktoy {
    Connection conn;        // Must be defined here as class variables, get their value in the login method
    Statement stmt;

    
        public Connection loggInn2(PrintWriter out) {
        try {
         // Step 1: Allocate a database 'Connection' object
         Context cont = new InitialContext();
         DataSource ds = (DataSource)cont.lookup("java:comp/env/jdbc/localhostDS");  
         //DataSource ds = (DataSource)cont.lookup("jdbc/localhostDS");
         conn =  ds.getConnection();
         stmt = conn.createStatement();
         
 
        }
        catch (SQLException ex ) {
            out.println("Not connected to database " +ex);
        }
        catch (NamingException nex) {
            out.println("Not correct naming" + nex);
        }
        
       return conn; 
    }  // end loggInn2
}    
    