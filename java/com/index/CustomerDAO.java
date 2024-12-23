package com.index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/custom", "root", "basu");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int save(Customer u) {
        int status = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            if (conn == null) {
                throw new SQLException("Connection failed: Unable to connect to the database.");
            }
            ps = conn.prepareStatement(
                "select from custom(full_name,email,phone_number,street_address,city,state,postal_code,country) VALUES(?, ?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, u.getCust_name());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPhone_number());
            ps.setString(4, u.getStreet_address());
            ps.setString(5, u.getCity());
            ps.setString(6, u.getState());
            ps.setString(7, u.getPostal_code());
            ps.setString(8, u.getCountry());

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

}
