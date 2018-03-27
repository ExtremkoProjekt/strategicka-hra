package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author MATEJ
 */

public class DatabaseHandleTables {

    public static void createTables() throws ClassNotFoundException, SQLException {
        Connection c = DatabaseConnection.getConnection();
        c.setAutoCommit(false);
        Statement stmt;     
        stmt = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS USER " +
                   "(USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
<<<<<<< HEAD
                + "TEXTFILE INTEGER"    
=======
                + "NAME TEXT, "
                + "TEXTFILE TEXT"    
>>>>>>> origin/master
                + ");";
        stmt.executeUpdate(sql);
        sql = "CREATE TABLE IF NOT EXISTS TOWNS " +
                "(TOWN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "GOLD INTEGER, "
                + "USER_ID, "
                + "FOREIGN KEY(USER_ID) REFERENCES TOWNS(USER_ID)"
                + ");";
        
        stmt.executeUpdate(sql);
        stmt.close();
        c.commit(); 
        
   
    }
    
<<<<<<< HEAD
=======
    public static void dropTables() throws SQLException, ClassNotFoundException {
        Connection c = DatabaseConnection.getConnection();
        c.setAutoCommit(false);
        Statement stmt;     
        stmt = c.createStatement();
        String sql = "DROP TABLE IF EXISTS USER; "
                + "DROP TABLE IF EXISTS TOWNS" ;
                 
     
        stmt.executeUpdate(sql);
        stmt.close();
        c.commit(); 
        
        
    }
    
>>>>>>> origin/master
    
    
}

