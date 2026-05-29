package car;

import java.sql.*;

public class DatabaseHelper {

    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/car maintenance and service management system"; // Database URL
        String user = "root"; // Database username
        String password = "Gowtham@2006"; // Database password
        return DriverManager.getConnection(url, user, password);
    }

    // Method to close the database connection
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}
