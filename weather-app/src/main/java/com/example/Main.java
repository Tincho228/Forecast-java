package com.example;

import com.example.controller.WeatherController;

public class Main {
    public WeatherController weatherController;
        public static void main(String[] args) {
            Main mainInstance = new Main();
            mainInstance.weatherController = new WeatherController("44.34", "10.99");
            mainInstance.weatherController.getWeatherForecast();
    }
}