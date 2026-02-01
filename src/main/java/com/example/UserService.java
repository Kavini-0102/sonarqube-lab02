package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    private final String password;

    public UserService() {
        // In real app, this would come from environment variable
        this.password = System.getenv("DB_PASSWORD") != null ? 
                        System.getenv("DB_PASSWORD") : "password123";
    }

    public void findUser(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    logger.log(Level.INFO, "User found: {0}", name);
                }
            }
        }
    }

    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            pstmt.execute();
        }
    }
}