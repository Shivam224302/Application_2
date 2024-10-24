package com.weatherapp;

public class AlertService {

    // Method to send alert based on weather conditions
    public void sendAlert(String city, double temperature) {
        if (temperature > 40) {
            System.out.println("Heatwave Alert for " + city + ": Temperature is above 40°C");
        } else if (temperature < 5) {
            System.out.println("Cold Wave Alert for " + city + ": Temperature is below 5°C");
        }
    }
}
