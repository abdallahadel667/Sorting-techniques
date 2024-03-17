import java.io.*;
import java.util.*;

// Class for reading integers from a file
public class ReadTesetCases {
    String fileName; // Name of the file to read from
    ArrayList<Integer> arrayList = new ArrayList<>(); // ArrayList to store integers
    ArrayList<ArrayList<Integer>> arrayListList = new ArrayList<>();

    // Constructor to initialize the file name
    public ReadTesetCases(String fileName) {
        this.fileName = fileName;
    }

    // Method to read integers from the file and store them in an ArrayList
    public ArrayList<ArrayList<Integer>> read() throws IOException {
        try {
            // Open the file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {

                // Extract the array content from the line
                String temp = line.split("=")[1].trim(); // Assuming the format is "array = {...}"
                temp = temp.replaceAll("\\[|\\]|\\{|\\}", ""); // Remove square brackets and curly braces
                String[] arrayContent = temp.split(", "); // Split the content by comma and space

                // Convert string elements to integers and add them to the ArrayList
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (String s : arrayContent) {
                    arrayList.add(Integer.parseInt(s));
                }

                // Add the ArrayList to the list of ArrayLists
                arrayListList.add(arrayList);
            }
            reader.close();
            return arrayListList;
             // Close the file
        } catch (IOException e) {

            // Handle IO exception
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
            return null;
        }
        

    }
}
