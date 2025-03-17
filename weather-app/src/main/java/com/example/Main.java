package com.example;
import java.util.List;
import com.example.controller.WeatherController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("WELCOME TO WEATHER API:");
            System.out.println("Please Select an option:");
            System.out.println("a - Forecast by City.");
            System.out.println("b - Forecast by Coordinates.");
            System.out.println("c - History of Searching.");
            System.out.println("d - Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "a" -> {
                    System.out.print("Enter city name: ");
                    String cityName = scanner.nextLine();
                    // Initialize WeatherController with valid input
                    WeatherController weatherController = new WeatherController(cityName);
                    
                }
                case "b" -> {
                    System.out.print("Enter latitude: ");
                    String latitudeInput = scanner.nextLine();
                    System.out.print("Enter longitude: ");
                    String longitudeInput = scanner.nextLine();

                    if (isValidLatitude(latitudeInput) && isValidLongitude(longitudeInput)) {
                        // Initialize WeatherController with valid input
                        
                        WeatherController weatherController = new WeatherController(latitudeInput, longitudeInput);
                        
                    } else {
                        System.out.println("Invalid latitude or longitude. Please try again.");
                    }
                }
                case "c" -> {
                    // Creating a List to store the search history
                    List<String> searchHistory = new WeatherController().getHistoryFromFile();
                    System.out.println("Search History:");
                    if (searchHistory.isEmpty()) {
                        System.out.println("No searches yet.");
                    } else {
                        for (String search : searchHistory) {
                            System.out.println(search);
                        }
                    }
                }
                case "d" -> {
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    // HELPER FUNCTIONS
    // This function checks if the input latitude is valid
    // Usually, the valid latitude is between -90 and 90.
    public static boolean isValidLatitude(String latitude) {
        try {
            double lat = Double.parseDouble(latitude);
            return lat >= -90 && lat <= 90;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // This function checks if the input longitude is valid. 
    // Usually, the valid longitude is between -180 and 180.
    public static boolean isValidLongitude(String longitude) {
        try {
            double lon = Double.parseDouble(longitude);
            return lon >= -180 && lon <= 180;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
