package com.example.model;

public class HourForecast {
    private String date;        // Specific date (e.g., "FRIDAY 14 of MARCH, 2025")
    private String time;        // Specific Hour (e.g., "12:00")
    private double temperature; // Temperature (e.g., 282.55°C)
    private int humidity;       // Humidity (e.g., 91%)
    private String description; // Weather description (e.g., "overcast clouds")
    private String icon;        // Weather icon (e.g., "04d")
    private double windSpeed;   // Wind speed (e.g., 0.83 mph)

    // Constructor vacío
    public HourForecast() {
    }

    // Constructor con parámetros
    public HourForecast(String date, String time, double temperature, int humidity, String description, String icon, double windSpeed) {
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
        this.icon = icon;
        this.windSpeed = windSpeed;
    }

    // Getters y setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return date + " " + time + "\n" +
               "Temperature: " + temperature + "°C\n" +
               "Humidity: " + humidity + "%\n" +
               "Description: " + description + "\n" +
               "Icon: " + icon + "\n" +
               "Wind speed: " + windSpeed + " mph\n";
    }
}