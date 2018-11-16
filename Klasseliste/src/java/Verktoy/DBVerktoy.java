package Verktoy;

import java.sql.Connection;
import java.sql.*; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author Team Machine
 */
public class DBVerktoy {
    Connection conn; 
    Statement stmt;
    
        public Connection loggInn2() {
        try {
         // Step 1: Allocate a database 'Connection' object
         Context cont = new InitialContext();
         DataSource ds = (DataSource)cont.lookup("java:comp/env/jdbc/classlist");  
         //DataSource ds = (DataSource)cont.lookup("jdbc/localhostDS");
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
    }  // end loggInn2
}    
    