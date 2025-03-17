package com.example.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HistoryModel {
    private static final String FILE_PATH = "search_history.txt";

    // Function to save a search entry to the file
    public void saveSearchToFile(String searchEntry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(searchEntry);
            writer.newLine(); // Add a new line after each entry
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    // Function to retrieve all search entries from the file as a single string
    public List<String> getAllSearchesFromFile() {
        List<String> searchEntries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                searchEntries.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return searchEntries;
    }
}