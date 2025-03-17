package com.example.controller;
import com.example.api.Api;
import com.example.model.WeatherModel;
import com.example.model.HistoryModel;
import java.util.List;
import com.example.view.WeatherView;
import com.example.model.CityForecast;

public class WeatherController {
    public Api api = new Api();
    public String response;
    private final HistoryModel historyModel;

    // Create an empty constructor
    public WeatherController() {
        this.historyModel = new HistoryModel();
    }
    public WeatherController(String cityName) {
        this.historyModel = new HistoryModel();
        // Call the API with the city name from the main
        this.response = this.api.callApibyCity(cityName);
        // Simulating the API call
        System.out.println("Fetching forecast for " + cityName + "...");
        // Check if the response is valid
        if (this.response.equals("GET request failed")) {
            System.out.println("City not found. Please try again.");
            return;
        }
        // Parse the response, sending information to the model
        WeatherModel weatherModel = new WeatherModel();
        // Send the information to the View.
        WeatherView weatherView = new WeatherView();
        // Initialize the CityForecast object
        CityForecast cityForecast;
        // Parsing Response from API
        cityForecast = weatherModel.parseWeatherResponseByCity(this.response);
        // Sending the model to the view.
        weatherView.showWeatherbyCity(cityForecast);
        // Save the search to the file  
        String currentDate = java.time.LocalDate.now().toString();
        String searchEntry ="Date: " + currentDate + ", City: " + cityName;
        // Calling function to save the search entry to the file
        historyModel.saveSearchToFile(searchEntry);
        
    }

    public WeatherController(String lat, String lon) {
        this.historyModel = new HistoryModel();

        // Save the search to the file
        String currentDate = java.time.LocalDate.now().toString();
        String searchEntry ="Date: " + currentDate + ", Latitude: " + lat + ", Longitude: " + lon;
        historyModel.saveSearchToFile(searchEntry);

        // Call the API with the lat and lon from the main
        this.response = this.api.callApi(lat, lon);
        // Parse the response
        WeatherModel weatherModel = new WeatherModel();
        // Send the information to the View
        WeatherView weatherView = new WeatherView();
        WeatherModel weatherModelForecast;
        weatherModelForecast = weatherModel.parseWeatherResponse(this.response);
        weatherView.showWeather(weatherModelForecast);
        
    }
    
    public List<String> getHistoryFromFile() {
        return historyModel.getAllSearchesFromFile();
    }
    
}
