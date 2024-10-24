package com.weatherapp;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.JSONObject;

public class WeatherService {
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private String apiKey;

    String city = "Delhi"; // dynamically change this for other cities
    
    // Constructor to initialize the API key
    public WeatherService(String apiKey) {
        this.apiKey = apiKey;
    }

    // Method to get weather for a specific city
    public String getWeather(String city) {
        try {
            // Build the API URL with city and API key
            String url = String.format("%s?q=%s&appid=%s&units=metric", API_URL, city, apiKey);

            // Make an HTTP GET request to the OpenWeather API
            HttpResponse<String> response = Unirest.get(url).asString();
            
            if (response.getStatus() == 200) {
                // Parse and return the weather information from JSON response
                return parseWeatherData(response.getBody());
            } else {
                return "Failed to retrieve weather data for " + city + ": " + response.getBody();
            }
        } catch (Exception e) {
            return "Error fetching weather data for " + city + ": " + e.getMessage();
        }
    }

    // Method to parse the JSON response and return weather information
    private String parseWeatherData(String json) {
        JSONObject jsonObject = new JSONObject(json);
        String cityName = jsonObject.getString("name");
        JSONObject main = jsonObject.getJSONObject("main");
        double temperature = main.getDouble("temp");
        int humidity = main.getInt("humidity");

        return String.format("City: %s, Temp: %.2f°C, Humidity: %d%%", cityName, temperature, humidity);
    }
}
