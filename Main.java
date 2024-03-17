import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        String filePath;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        filePath = sc.nextLine();

        // ReadTesetCases rf = new ReadTesetCases(fileName);
        ReadFile rf2 = new ReadFile(filePath);
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayListList = new ArrayList<>();
        long startTime, endTime;

        try {
            // read line from txt file
            array = rf2.read();

            // startTime = System.nanoTime();
            // arr.sort(null);
            // endTime=System.nanoTime();
            // System.out.println("Time taken to sort the array: " + (endTime-startTime) +
            // "ns");
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
            e.printStackTrace();
            sc.close();
        }
        while (true) {
            System.out.println("Welcome to the sorting program");
            System.out.println("................................");
            System.out.println(" Please select the type of output you want:");
            System.out.println("1. Return the sorted array only");
            System.out.println("2. Return the intermediate steps of the sorting algorithm");
            System.out.println("3. Exit");
            int choiceFormate = sc.nextInt();

            if (choiceFormate == 1) {
                System.out.println("You have selected to return the sorted array only");
            } else if (choiceFormate == 2) {
                System.out.println("You have selected to return the intermediate steps of the sorting algorithm");
            }

            else if (choiceFormate == 3) {
                System.out.println("Exiting the program");
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
                continue;

            }

            sortArray(array, choiceFormate);// call the sortArray method

            array.sort(null);
            System.out.println(array);

            sc.close();
            break;

        }

    }

    public static void sortArray(ArrayList<Integer> array, int choiceFormate) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pleae select the sorting algorithm you want to use");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Counting Sort");
        System.out.println("4. Return to main menu");
        System.out.println("5. Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                if (choiceFormate == 1) {
                    System.out.println("You have selected Insertion Sort");
                    System.out.println("The sorted array is: ");
                    System.out.println(InsertionSort.sort(array, choiceFormate));
                } else if (choiceFormate == 2) {
                    System.out.println("You have selected Insertion Sort");
                    System.out.println("The intermediate steps of the sorting algorithm are: ");
                    InsertionSort.sort(array, choiceFormate);
                } else {
                    System.out.println("Invalid choice");
                }
                break;
            case 2:
                if (choiceFormate == 1) {
                    System.out.println("You have selected Merge Sort");
                    System.out.println("The sorted array is: ");
                    System.out.println(MergeSort.sort(array, choiceFormate));
                } else if (choiceFormate == 2) {
                    System.out.println("You have selected Merge Sort");
                    System.out.println("The intermediate steps of the sorting algorithm are: ");
                    MergeSort.sort(array, choiceFormate);
                } else {
                    System.out.println("Invalid choice");
                }
                break;
            case 3:
                if (choiceFormate == 1) {
                    System.out.println("You have selected Counting Sort");
                    System.out.println("The sorted array is: ");
                    System.out.println(CountingSort.sort(array, choiceFormate));
                } else if (choiceFormate == 2) {
                    System.out.println("You have selected Counting Sort");
                    System.out.println("The intermediate steps of the sorting algorithm are: ");
                    CountingSort.sort(array, choiceFormate);
                } else {
                    System.out.println("Invalid choice");
                }
                break;
            case 4:
                System.out.println("Returning to main menu");
                break;
            case 5:
                System.out.println("Exiting the program");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice\n You will be directed to the main menu");
                break;
        }

    }
}