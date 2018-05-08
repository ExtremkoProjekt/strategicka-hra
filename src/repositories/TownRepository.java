package repositories;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MATEJ
 */
public class TownRepository {
    //adds town to database
    public static void add(String name, int userID) throws ClassNotFoundException, SQLException {
        Connection c = DatabaseConnection.getConnection();
        c.setAutoCommit(false);
        String sql = "INSERT INTO TOWN (NAME, USER_ID) VALUES (?, ?);"; 
        PreparedStatement pstmt;
        pstmt = c.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setInt(2, userID);
        pstmt.executeUpdate();
        pstmt.close();
        c.commit();
        c.setAutoCommit(true);
    }
     
    public static boolean exists(String name) throws ClassNotFoundException, SQLException {
        Connection c = DatabaseConnection.getConnection();
        PreparedStatement pstmt;
        String sql = "SELECT * FROM TOWN WHERE NAME = ?;";
        pstmt = c.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();  
    }
    
    public static int get_gold_amount(String townName) throws ClassNotFoundException, SQLException {
        Connection c = DatabaseConnection.getConnection();
        PreparedStatement pstmt;
        String sql = "SELECT GOLD FROM TOWN WHERE NAME = ?;";
        pstmt = c.prepareStatement(sql);
        pstmt.setString(1, townName);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt("GOLD");   
    }

    public static int townCount() throws SQLException, ClassNotFoundException {
        Connection c = DatabaseConnection.getConnection();
        PreparedStatement pstmt;
        String sql = "SELECT COUNT(*) U_COUNT FROM TOWN";

        pstmt = c.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int res = rs.getInt("U_COUNT");
        rs.close();
        pstmt.close();
        return res;
    }
}