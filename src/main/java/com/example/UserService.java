package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials
    private String password = "admin123";

    // VULNERABILITY: SQL Injection
    public void findUser(String username) throws SQLException {
    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/db", "root", password);
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(
             "SELECT * FROM users WHERE name = '" + username + "'")) {
        
        while (rs.next()) {
            logger.info(rs.getString("name"));
        }
    }
}

    // SMELL: Unused method
    public void notUsed() {
        logger.info("I am never called");
    }
    // FIXED: Using try-with-resources and specific exceptions
    public void deleteUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", password);
            Statement st = conn.createStatement()) {
            
            String query = "DELETE FROM users WHERE name = '" + username + "'";
            st.execute(query);
        }
    }
}
