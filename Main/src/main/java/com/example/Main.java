package com.example;
import  com.example.CountingSort.CountingSort;
import  com.example.EfficientSort.EfficientSort;
import  com.example.InsertionSort.SimpleSort;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filePath;
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayListList = new ArrayList<>();
        int choice = 1;

        while (true) {
            if (choice == 1) {
                System.out.println("Welcome to the sorting program");
                System.out.println("................................");
                System.out.println("Please provide the path of the file containing the array to be sorted: ");
                filePath = sc.nextLine();
                ReadFile rf2 = new ReadFile(filePath);
                try {
                    // read line from txt file
                    array = rf2.read();
                } catch (IOException e) {
                    System.out.println("Error reading file: " + filePath);
                    e.printStackTrace();
                    continue;
                }
            }

            System.out.println("The array to be sorted is: " + array);
            sortArrayMenu(array);
            System.out.println("Do you want to try another sorting algorithm with different array?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("3. Exit");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline character
            if (choice == 3) {
                System.out.println("Exiting the program");
                System.exit(0);
            }
        }

    }

    public static void sortArrayMenu(ArrayList<Integer> array) {
        CountingSort countingSort = new CountingSort(array);
        SimpleSort insertionSort = new SimpleSort();
        EfficientSort mergeSort = new EfficientSort();
        int choiceFormate = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Pleae select the sorting algorithm you want to use");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Counting Sort");
        System.out.println("4. Exit");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You have selected Insertion Sort");
                choiceFormate = ReturnFormate();
                if (choiceFormate == 1) {

                    System.out.println("The sorted array is: ");
                    System.out.println(insertionSort.insertionSort(array));
                } else if (choiceFormate == 2) {

                    System.out.println("The intermediate steps of the sorting algorithm are: ");
                    System.out.println(insertionSort.sort(array));

                } else {
                    System.out.println("Invalid choice");
                }
                break;
            case 2:
                System.out.println("You have selected Merge Sort");
                choiceFormate = ReturnFormate();
                if (choiceFormate == 1) {

                    System.out.println("The sorted array is: ");
                    System.out.println(mergeSort.MergeSort(array, false));

                } else if (choiceFormate == 2) {
                    System.out.println("The intermediate steps of the sorting algorithm are: ");
                    mergeSort.MergeSort(array, true);
                } else {
                    System.out.println("Invalid choice");
                }
                break;
            case 3:
                System.out.println("You have selected Counting Sort");
                choiceFormate = ReturnFormate();
                if (choiceFormate == 1) {

                    System.out.println("The sorted array is: ");
                    countingSort.printFinal();
                } else if (choiceFormate == 2) {

                    System.out.println("The intermediate steps of the sorting algorithm are: ");
                    countingSort.printIntermediate();
                } else {
                    System.out.println("Invalid choice");
                }
                break;
            case 4:
                System.out.println("Exiting the program");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice\n You will be directed to the main menu");
                break;
        }

    }

    public static int ReturnFormate() {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println(" Please select the type of output you want:");
            System.out.println("1. Return the sorted array only");
            System.out.println("2. Return the intermediate steps of the sorting algorithm");
            System.out.println("3. Exit");
            int choiceFormate = sc.nextInt();

            if (choiceFormate == 1) {
                System.out.println("You have selected to return the sorted array only");
                return 1;
            } else if (choiceFormate == 2) {
                System.out.println("You have selected to return the intermediate steps of the sorting algorithm");
                return 2;
            } else if (choiceFormate == 3) {
                System.out.println("Exiting the program");
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
                continue;

            }
        }

    }

}