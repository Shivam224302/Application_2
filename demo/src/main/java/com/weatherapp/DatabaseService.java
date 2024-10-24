package com.weatherapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseService {

    private Connection connect() {
        // Connect to a database (you can replace this with your DB URL and credentials)
        String url = "jdbc:mysql://localhost:3306/weatherdb";
        String user = "root";
        String password = "password";
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

    // Method to store weather data in the database
    public void saveWeatherData(String city, double temperature, int humidity) {
        String sql = "INSERT INTO weather_data(city, temperature, humidity) VALUES (?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, city);
            pstmt.setDouble(2, temperature);
            pstmt.setInt(3, humidity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
