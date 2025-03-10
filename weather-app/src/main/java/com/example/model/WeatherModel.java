package com.example.model;

public class WeatherModel {
    public WeatherModel[] weatherModelList;
    public String city;
    public String temperature;
    public String description;
    public String humidity;
    public String windSpeed;
    public String date;
    public String time;
    public String icon;

    public WeatherModel() {

    }

    public WeatherModel(String city, String temperature, String description, String humidity, String windSpeed, String date, String time, String icon) {
        this.city = city;
        this.temperature = temperature;
        this.description = description;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.date = date;
        this.time = time;
        this.icon = icon;
    }
    
}
