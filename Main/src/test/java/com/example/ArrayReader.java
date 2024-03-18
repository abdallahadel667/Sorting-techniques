package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


// Class for reading integers from a file
public class ArrayReader {
    String fileName; // Name of the file to read from
    ArrayList<Integer> arr = new ArrayList<>(); // ArrayList to store integers
    ArrayList<ArrayList<Integer>> arrayListList = new ArrayList<>();

    // Constructor to initialize the file name
    public ArrayReader(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<ArrayList<Integer>> read() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                // Trim leading and trailing whitespace, and remove the square brackets
                String temp = line.trim().replaceAll("^\\[|\\]$", "");
                // Split the string by commas, potentially surrounded by whitespace
                String[] arrayContent = temp.split("\\s*,\\s*");

                ArrayList<Integer> arrayList = new ArrayList<>();
                for (String s : arrayContent) {
                    try {
                        arrayList.add(Integer.parseInt(s.trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid number format: " + s);
                        // Optionally, log the error or handle it as needed
                    }
                }

                arrayListList.add(arrayList);
            }
            reader.close();
            return arrayListList;
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
            return null;
        }
    }

}