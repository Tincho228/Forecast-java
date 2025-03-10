package com.example;

import com.example.controller.WeatherController;

public class Main {
    public WeatherController weatherController;
        public static void main(String[] args) {
            Main mainInstance = new Main();
            mainInstance.weatherController = new WeatherController("44.34", "10.99");
            //mainInstance.weatherController.getWeatherForecast();
            // Mañana comenzar a trabajar en el método parseWeatherResponse
            // El modelo debe parsear la respuesta y devolver un array de WeatherModel ordenado
            //mainInstance.weatherController.parseWeatherResponse();
    }
}