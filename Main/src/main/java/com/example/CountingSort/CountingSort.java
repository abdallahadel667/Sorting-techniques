package com.example.CountingSort;

import java.util.ArrayList;
import java.util.Collections;

public class CountingSort {
    // Declare class variables
    private ArrayList<Integer> list; // Input list to be sorted
    private int size; // Size of the input list
    private ArrayList<int[]> intermediateArrayList = new ArrayList<>(); // To store intermediate steps during sorting
    private int[] finalArray; // To store the final sorted array

    // Constructor
    public CountingSort(ArrayList<Integer> list) {
        this.list = list;
        this.size = list.size();
        this.finalArray = new int[size]; // Initialize finalArray with correct size
    }

    // Sorting method
    public int[] sort() {
        // Assuming that all integers are non-negative

        // Finding the max value in the array
        int max = Collections.max(list);

        // Initialize frequency array
        int[] freq_arr = new int[max + 1];

        // Counting the number of occurrences of each element
        for (int i = 0; i < size; i++) {
            freq_arr[list.get(i)]++;
        }

        // Getting cumulative sum
        for (int i = 1; i <= max; i++) {
            freq_arr[i] += freq_arr[i - 1];
        }

        // Return the frequency array
        return freq_arr;
    }

    // Method to return intermediate arrays generated during sorting
    ArrayList<int[]> returnIntermediateArrays() {
        // Perform sorting
        int[] freq_arr = sort();
        int[] ans = new int[size];

        // Generate intermediate arrays
        for (int i = size - 1; i >= 0; i--) {
            int value = list.get(i);
            freq_arr[value]--;
            ans[freq_arr[value]] = value;
            int[] snapShot = ans.clone();
            this.intermediateArrayList.add(snapShot); // Add snapshot to intermediateArrayList
        }

        // Return intermediate arrays
        return intermediateArrayList;
    }

    // Method to return the final sorted array
    public int[] returnFinalSorted() {
        // Perform sorting
        int[] freq_arr = sort();
        int[] ans = new int[size];

        // Generate final sorted array
        for (int i = size - 1; i >= 0; i--) {
            int value = list.get(i);
            freq_arr[value]--;
            ans[freq_arr[value]] = value;
        }

        // Return the final sorted array
        return ans;
    }

    // Method to print intermediate arrays
    public void printIntermediate() {
        // Get intermediate arrays
        this.intermediateArrayList = returnIntermediateArrays();

        // Print intermediate arrays
        System.out.println("The intermediate steps of the sorting algorithm are: ");
        for (int[] arr : intermediateArrayList) {
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i]);
                if (i != size - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            
        }
    }

    // Method to print the final sorted array
    public void printFinal() {
        // Get final sorted array
        this.finalArray = returnFinalSorted();

        // Print final sorted array
        //System.out.println("The sorted array is: ");
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(finalArray[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
