package com.example.view;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import com.example.model.CityForecast;
import com.example.model.HourForecast;
import com.example.model.WeatherModel;

public class WeatherView {
    public void showWeather(WeatherModel weatherModel) {
        System.out.println("City: " + weatherModel.getCityName());
        System.out.println("Country: " + weatherModel.getCountryName());
        System.out.println();

        // Group forecasts by date
        List<HourForecast> hourForecastList = weatherModel.getHourForecastList();
        Map<String, List<HourForecast>> forecastsByDay = hourForecastList.stream()
                .collect(Collectors.groupingBy(HourForecast::getDate, TreeMap::new, Collectors.toList()));

        // Display forecasts grouped by day
        for (Map.Entry<String, List<HourForecast>> entry : forecastsByDay.entrySet()) {
            String date = entry.getKey();
            List<HourForecast> forecasts = entry.getValue();

            // Print the day
            System.out.println("Date: " + date);
            System.out.println("---------------------------------------------");

            // Print the table header
            System.out.printf("%-10s %-10s %-15s %-10s %-20s %-10s%n",
                    "Time", "Temp", "Humidity", "Wind", "Description", "Icon");

            // Print each forecast for the day without the speed column
            for (HourForecast forecast : forecasts) {
                System.out.printf("%-10s %-10s %-15s %-10s %-20s %-10s%n",
                        forecast.getTime(),
                        forecast.getTemperature(),
                        forecast.getHumidity(),
                        forecast.getWindSpeed(),
                        forecast.getDescription(),
                        forecast.getIcon());
            }

            System.out.println(); // Add a blank line between days
        }
    }
    public void showWeatherbyCity(CityForecast forecast) {
        System.out.println("+------------------------+----------------------------------------+");
    System.out.printf("| %-22s | %-38s |\n", "Variable", "Value");
    System.out.println("+------------------------+----------------------------------------+");

    System.out.printf("| %-22s | %-38s |\n", "City", forecast.getCityName());
    System.out.printf("| %-22s | %-38s |\n", "Country", forecast.getCountryName());
    System.out.printf("| %-22s | %-38.2f |\n", "Latitude", forecast.getLat());
    System.out.printf("| %-22s | %-38.2f |\n", "Longitude", forecast.getLon());
    System.out.printf("| %-22s | %-38s |\n", "Date", forecast.getDate());
    System.out.printf("| %-22s | %-38s |\n", "Time", forecast.getTime());
    System.out.printf("| %-22s | %-38.2f |\n", "Temperature (°F)", forecast.getTemperature());
    System.out.printf("| %-22s | %-38d |\n", "Humidity (%)", forecast.getHumidity());
    System.out.printf("| %-22s | %-38s |\n", "Description", forecast.getDescription());
    System.out.printf("| %-22s | %-38s |\n", "Icon", forecast.getIcon());
    System.out.printf("| %-22s | %-38.2f |\n", "Wind Speed (m/s)", forecast.getWindSpeed());

    System.out.println("+------------------------+----------------------------------------+");
    }
    
}
