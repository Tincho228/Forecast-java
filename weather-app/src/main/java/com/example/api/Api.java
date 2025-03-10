package com.example.api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {
    private static final String API_KEY = "0bd1671316868f5ad2775ab7ede5bf47"; 
    private static final String BASE_URL = "https://pro.openweathermap.org/data/2.5/forecast?lat=";
    
    
    public String callApi(String lat, String lon) {
        String endpoint = BASE_URL + lat + "&lon=" + lon + "&appid=" + API_KEY ;
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    return response.toString();
                }
            } else {
                return "GET request failed";
            }
        } catch (java.net.MalformedURLException e) {
            System.err.println("MalformedURLException: " + e.getMessage());
            return "MalformedURLException: " + e.getMessage();
        } catch (java.io.IOException e) {
            System.err.println("IOException: " + e.getMessage());
            return "IOException: " + e.getMessage();
        }
    }
}
