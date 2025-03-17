package com.example.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherModel {
    private String cityName;
    private String countryName;
    private List<HourForecast> hourlyForecasts;


    // *********** CONSTRUCTORS ***********

    // Empty constructor
    public WeatherModel() {
        // Initialize the list of hourly forecasts
        
    }
    // Constructor with parameters
    public WeatherModel(String cityName, String countryName, List<HourForecast> hourForecastList) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.hourlyForecasts = hourForecastList;
    }

    // *********** SPECIAL METHODS ***********
    // 
        // The parseWeatherResponse method processes a JSON weather API response to extract and organize weather data. 
        // It initializes a list of hourly forecasts and retrieves
        // the city and country names. Then, it iterates through the "list" array 
        // in the JSON, extracting details like date, time, temperature, humidity, weather description, icon, and wind speed for each forecast. 
        // These details are used to create HourForecast objects, which are added to the hourlyForecasts list. 
        // The method converts timestamps to human-readable date and time formats using LocalDateTime. 
        // This prepares the weather data for easy access and display in the application.
    public WeatherModel parseWeatherResponse(String jsonResponse) {
        // Create a new Weather Model Object
        
        JSONObject json = new JSONObject(jsonResponse);
        JSONArray weatherArray = json.getJSONArray("list");
        JSONObject cityInfo = json.getJSONObject("city");
        // Initilization of the list of hourly forecasts
        this.hourlyForecasts = new ArrayList<>();
        // Extract city and country names
        this.cityName = cityInfo.getString("name");
        this.countryName = cityInfo.getString("country");
        // Iteration through the "list" array in the JSON
        for (int i = 0; i < weatherArray.length(); i++) {
            JSONObject weatherObject = weatherArray.getJSONObject(i);

            // Extract date and time
            long dt = weatherObject.getLong("dt");
            LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(dt), ZoneId.systemDefault());
            String date = dateTime.getDayOfWeek() + " " + dateTime.getDayOfMonth() + " of " + dateTime.getMonth() + ", " + dateTime.getYear();
            String time = dateTime.getHour() + ":00";
            // Extract weather details
            JSONObject main = weatherObject.getJSONObject("main");
            Double temperature = main.getDouble("temp");
            int humidity = main.getInt("humidity");
            // Extracting the weather description and icon
            JSONArray weather = weatherObject.getJSONArray("weather");
            String description = weather.getJSONObject(0).getString("description");
            String icon = weather.getJSONObject(0).getString("icon");
            // Extracting wind speed
            JSONObject wind = weatherObject.getJSONObject("wind");
            double windSpeed = wind.getDouble("speed");

            // Create HourForecast object
            HourForecast forecast = new HourForecast(date, time, temperature, humidity, description, icon, windSpeed);
            this.hourlyForecasts.add(forecast);
        }
        WeatherModel weatherModel = new WeatherModel(cityName, countryName, hourlyForecasts);
        return weatherModel;
        
    }

    public CityForecast parseWeatherResponseByCity(String jsonResponse) {
        // Parse the JSON response
        JSONObject json = new JSONObject(jsonResponse);

        // Extract city name and country
        String parsedCityName = json.getString("name");
        String parsedCountryName = json.getJSONObject("sys").getString("country");
        // Extract lat and lon
        double lat = json.getJSONObject("coord").getDouble("lat");
        double lon = json.getJSONObject("coord").getDouble("lon");
        // Extract main weather details
        JSONObject main = json.getJSONObject("main");
        double temperature = main.getDouble("temp");
        int humidity = main.getInt("humidity");
        // Extract weather description and icon
        JSONArray weatherArray = json.getJSONArray("weather");
        String description = weatherArray.getJSONObject(0).getString("description");
        String icon = weatherArray.getJSONObject(0).getString("icon");

        // Extract wind speed
        JSONObject wind = json.getJSONObject("wind");
        double windSpeed = wind.getDouble("speed");

        // Extract date and time
        long dt = json.getLong("dt");
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(dt), ZoneId.systemDefault());
        String date = dateTime.getDayOfWeek() + " " + dateTime.getDayOfMonth() + " of " + dateTime.getMonth() + ", " + dateTime.getYear();
        String time = dateTime.getHour() + ":00";

        // Create and return a CityForecast object
        return new CityForecast(parsedCityName, parsedCountryName, lat, lon, date, time, temperature, humidity, description, icon, windSpeed);
    }

    // *********** GETTERS AND SETTERS ***********

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<HourForecast> getHourForecastList() {
        return hourlyForecasts;
    }

    public void setHourForecastList(List<HourForecast> hourForecastList) {
        this.hourlyForecasts = hourForecastList;
    }
    
}
