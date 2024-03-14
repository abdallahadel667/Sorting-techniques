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
        

        while(true){
            
            try{
                //read line from txt file
                array= rf2.read();
            
                // startTime = System.nanoTime();
                // arr.sort(null);
                // endTime=System.nanoTime();
                // System.out.println("Time taken to sort the array: " + (endTime-startTime) + "ns");
            }
            catch (IOException e){
                System.out.println("Error reading file: " + filePath);
                e.printStackTrace();
                sc.close();
            }

            array.sort(null);
            System.out.println(array);
            

            sc.close();
            break;

    }
    
}

}