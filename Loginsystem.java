//import java.sql.*;
//
//public class Loginsystem {
//    public static boolean login(String username, String password) {
//        try (Connection conn = DBConnection.getConnection()) {
//            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, username);
//            ps.setString(2, password);
//            ResultSet rs = ps.executeQuery();
//            return rs.next();
//        } catch (Exception e) {
//            System.out.println("Login failed: " + e.getMessage());
//            return false;
//        }
//    }
//}

//-----------------------------------------------------
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class Loginsystem {
//    public static boolean login(String username, String password, Connection conn) {
//        try {
//            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, username);
//            ps.setString(2, password);
//            ResultSet rs = ps.executeQuery();
//            return rs.next(); // true if match found
//        } catch (Exception e) {
//            System.out.println("❌ Login failed: " + e.getMessage());
//            return false;
//        }
//    }
//}
//-----------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Loginsystem {
    public static boolean login(String username, String password, Connection conn) {
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("\u274C Login failed: " + e.getMessage());
            return false;
        }
    }
}
//
