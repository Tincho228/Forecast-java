package com.example.controller;

import com.example.api.Api;
import com.example.view.WeatherView;

public class WeatherController {
    public Api api = new Api();
    public WeatherView weatherView = new WeatherView();
    public String response;

    public WeatherController(String lat, String lon) {
        this.response = this.api.callApi("44.34","10.99");
    }
    
    public void getWeatherForecast() {
        System.out.println(this.response);
    }
}
