

    import java.sql.*;

    public class DBConnection {
        static final String URL = "jdbc:mysql://localhost:3306/reservation_db";
        static final String USER = "root";
        static final String PASS = "@Aries02042004";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASS);
        }
    }


