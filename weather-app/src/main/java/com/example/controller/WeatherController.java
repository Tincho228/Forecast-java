package com.example.controller;

import com.example.api.Api;
import com.example.model.WeatherModel;
import com.example.view.WeatherView;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherController {
    public WeatherModel[] weatherModelList;
    public Api api = new Api();
    public WeatherView weatherView = new WeatherView();
    public String response;

    public WeatherController(String lat, String lon) {
        this.response = this.api.callApi("44.34","10.99");
        // 1. Send response to the model and come back to the controller with the List of WeatherModel
        
    }
    
    public void getWeatherForecast() {
        this.weatherView.showWeather(response);
        // 2. Send the response to the view
    }
    public void parseWeatherResponse(String response) {
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray weatherArray = jsonResponse.getJSONArray("list");
        JSONObject city = jsonResponse.getJSONObject("city");

        String cityName = city.getString("name");
        String countryName = city.getString("country");
        System.out.println("City: " + cityName);
        System.out.println("Country: " + countryName);
        this.weatherModelList = new WeatherModel[weatherArray.length()];

        for (int i = 0; i < weatherArray.length(); i++) {
            JSONObject weatherObject = weatherArray.getJSONObject(i);

                    // Extract "dt" which is the date and time of the forecast
            long dt = weatherObject.getLong("dt");
            LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(dt), ZoneId.systemDefault());
            int day = dateTime.getDayOfMonth();
            // int month = dateTime.getMonthValue();
            int year = dateTime.getYear();
            int hour = dateTime.getHour();
            String dayOfWeek = dateTime.getDayOfWeek().toString();
            String monthName = dateTime.getMonth().toString();
            
                    // Extract temp and humedity from "main"
            JSONObject main = weatherObject.getJSONObject("main");
            double temp = main.getDouble("temp");
            int humidity = main.getInt("humidity");

                    // Extraer "description" e "icon" del primer elemento en "weather"
            JSONArray weather = weatherObject.getJSONArray("weather");
            String description = weather.getJSONObject(0).getString("description");
            String icon = weather.getJSONObject(0).getString("icon");
            // Icon URL "http://openweathermap.org/img/w/" + iconcode + ".png";

            // Extract "speed" from "wind"
            JSONObject wind = weatherObject.getJSONObject("wind");
            double windSpeed = wind.getDouble("speed");

            System.out.println(dayOfWeek + " " + day + " of " + monthName + ", " + year + " " + hour + ":" + "00");
            System.out.println("Temperature: " + temp + "°C");
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Description: " + description);
            System.out.println("Icon: " + icon);
            double windSpeedMph = Math.round(windSpeed * 2.23694 * 100.0) / 100.0;
            System.out.println("Wind speed: " + windSpeedMph + " mph");
         }
        
    }
}
