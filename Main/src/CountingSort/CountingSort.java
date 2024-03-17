package CountingSort;

import java.util.ArrayList;
import java.util.Collections;

public class CountingSort {
    private ArrayList<Integer> list;
    private int size; 

    public CountingSort(ArrayList<Integer> list) {
        this.list = list;
        this.size = list.size();
    }

    public int[] sort() {
        // Assuming that all integers are non-negative
        // finding the max value in the array
        int max = Collections.max(list);
        // Initialize frequency array
        int[] freq_arr = new int[max + 1];
        int[] ans = new int[size];
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        // Counting the number of occurences
        for (int i = 0; i < size; i++) {
            freq_arr[list.get(i)]++;
        }
        // Getting cumulative sum
        for (int i = 1; i <= max; i++) {
            freq_arr[i] += freq_arr[i - 1];
        }
        return freq_arr;
    }

    ArrayList<int[]> returnIntermediateArrays() {
        int[] freq_arr = sort();
        int[] ans = new int[size];
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        for (int i = size - 1; i >= 0; i--) {
            int value = list.get(i);
            freq_arr[value]--;
            ans[freq_arr[value]] = value;
            int[] snapShot = ans.clone();
            intermediateArrays.add(snapShot);
        }
        return intermediateArrays;
    }

    int[] returnFinalSorted() {
        int[] freq_arr = sort();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            int value = list.get(i);
            freq_arr[value]--;
            ans[freq_arr[value]] = value;
        }
        return ans;
    }
}