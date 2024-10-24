package com.weatherapp;

public class App {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService("c9677ef8aab6de6a611d90c4b687ee11");
        AlertService alertService = new AlertService();
        DatabaseService databaseService = new DatabaseService();

        String[] cities = { "Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad" };

        for (String city : cities) {
            String weatherData = weatherService.getWeather(city);
            System.out.println(weatherData);

            // Assuming you parse temperature and humidity from weatherData
            double temperature = extractTemperature(weatherData);
            int humidity = extractHumidity(weatherData);

            // Send alert if needed
            alertService.sendAlert(city, temperature);

            // Save data to database
            databaseService.saveWeatherData(city, temperature, humidity);
        }
    }

    private static double extractTemperature(String weatherData) {
        // Logic to extract temperature from weatherData
        return 40.0; // Placeholder
    }

    private static int extractHumidity(String weatherData) {
        // Logic to extract humidity from weatherData
        return 60; // Placeholder
    }
}
