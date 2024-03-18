package com.example.InsertionSort;
import java.util.*;

public class SimpleSort {

    ArrayList<ArrayList<Integer>> snapshots = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> sort(ArrayList<Integer> list) {
        // List to hold the snapshots after each iteration
        ArrayList<ArrayList<Integer>> snapshots = new ArrayList<>();
        snapshots.add(copy(list));
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (list.get(j) > temp) {
                    list.set(j + 1, list.get(j));
                } else
                    break;
            }
            list.set(j + 1, temp);
        
            snapshots.add(copy(list));
        }
        return snapshots;
    }

    public ArrayList<Integer> copy(ArrayList<Integer> list) {
        ArrayList<Integer> snapshot = new ArrayList<>();
        for (Integer item : list) {
            snapshot.add(Integer.valueOf(item));
        }
        return snapshot;
    }

    public ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        sort(list);
        return list;
    }

   
    }

    
    

    

