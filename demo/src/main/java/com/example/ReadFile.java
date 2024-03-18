package com.example;


import java.io.*;
import java.util.*;

// Class for reading integers from a file
public class ReadFile {
    String fileName; // Name of the file to read from
    ArrayList<Integer> arrayList = new ArrayList<>(); // ArrayList to store integers

    // Constructor to initialize the file name
    public ReadFile(String fileName) {
        this.fileName = fileName;
    }

    // Method to read integers from the file and store them in an ArrayList
    public ArrayList<Integer> read() throws IOException {
        try {
            // Open the file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine(); // Read the first line from the file
            reader.close(); // Close the file after reading

            // Extract the array content from the line
            String temp = line.split("=")[1].trim(); // Assuming the format is "array = {...}"
            temp = temp.replaceAll("\\[|\\]|\\{|\\}", ""); // Remove square brackets and curly braces
            String[] arrayContent = temp.split(", "); // Split the content by comma and space

            // Convert string elements to integers and add them to the ArrayList
            for (String s : arrayContent) {
                arrayList.add(Integer.parseInt(s));
            }

            return arrayList; // Return the ArrayList containing the integers
        } catch (IOException e) {
            // Handle IO exception
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
            return null;
        }
    }
}
