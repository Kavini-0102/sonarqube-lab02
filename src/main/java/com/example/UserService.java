package com.example;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;

public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    private String password = "password123";

    public void findUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", password);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(
                 "SELECT * FROM users WHERE name = '" + username + "'")) {
            
            while (rs.next()) {
                String name = rs.getString("name");
                logger.log(Level.INFO, "User found: {0}", name);
            }
        }
    }

    public void deleteUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", password);
             Statement st = conn.createStatement()) {
            
            String query = "DELETE FROM users WHERE name = '" + username + "'";
            st.execute(query);
        }
    }

}
