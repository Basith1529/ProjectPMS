package com.index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pt_store1", "root", "basu");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int save(User u) {
        int status = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            if (conn == null) {
                throw new SQLException("Connection failed: Unable to connect to the database.");
            }
            ps = conn.prepareStatement(
                "INSERT INTO users(username, age, phoneno, gender, email, password, confirm_password) VALUES(?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, u.getUsername());
            ps.setLong(2, u.getAge());
            ps.setString(3, u.getPhoneNo());
            ps.setString(4, u.getGender());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getPassword());
            ps.setString(7, u.getConfirm_password());

            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }
    public static boolean validateUser(String email, String password) {
        boolean isValid = false;
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            isValid = rs.next(); // True if a record exists
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }
    /*
    public static String getUserName(String email) {
        String name = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Js15042002@")) {
            String query = "SELECT name FROM users WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                name = rs.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    // Method to get the user's location by email
    public static String getUserLocation(String email) {
        String location = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Js15042002@")) {
            String query = "SELECT location FROM users WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                location = rs.getString("location");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }*/
    
    public static Map<String, Object> getUserDetails(String email) {
        Map<String, Object> userDetails = new HashMap<>();
        String query = "SELECT username, age,phoneno, gender FROM users WHERE email = ?";
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pt_store1", "root", "basu");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                userDetails.put("username", rs.getString("username"));
                userDetails.put("age", rs.getInt("age"));
                userDetails.put("phoneno", rs.getInt("phoneno"));
                userDetails.put("gender", rs.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetails;
    }
}
