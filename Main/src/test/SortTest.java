package test;

import CountingSort.CountingSort;
import InsertionSort.SimpleSort;
import Efficient.EfficientSort;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SortTest {
    /*
     * method to produce a random list of integers randomizing size and elements.
     * max size is 1000 and max element is 10000 "adjutable"
     */
    ArrayList<Integer> randomList() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        int size = random.nextInt(1000);

        for (int j = 0; j < size; j++) {
            list.add(random.nextInt(10000));
        }
        return list;
    }

    @Test // random case for insertion sort
    public void randomInsertionSortTest() {
        SimpleSort sorting = new SimpleSort();
        ArrayList<Integer> list = randomList();
        System.out.println(list);
        ArrayList<Integer> expected = new ArrayList<>(list);
        Collections.sort(expected);
        ArrayList<Integer> actual = sorting.insertionSort(list);
        assertEquals(expected, actual);
    }

    /*
     * Plug any algorithm to run this test and an appropriate time limit to be set.
     */
    @Test
    @Timeout(value = 8, unit = TimeUnit.MILLISECONDS)
    void timeLimitTestInsertion() {
        SimpleSort sorting = new SimpleSort();
        ArrayList<Integer> list = randomList();
        ArrayList<Integer> expected = new ArrayList<>(list);
        Collections.sort(expected);
        ArrayList<Integer> actual = sorting.insertionSort(list);
        assertEquals(expected, actual);
    }

    @Test // best case insertion sort array sorted
    void bestcaseInsertionSortTest() {
        SimpleSort sorting = new SimpleSort();
        ArrayList<Integer> list = randomList();
        ArrayList<Integer> expected = sorting.copy(list);
        Collections.sort(expected);
        ArrayList<Integer> actual = sorting.insertionSort(list);
        assertEquals(expected, actual);
    }

    @Test // worst case insertion sort array reversed
    void worstcaseInsertionSortTest() {
        SimpleSort sorting = new SimpleSort();
        ArrayList<Integer> list = randomList();
        Collections.sort(list, Collections.reverseOrder());
        ArrayList<Integer> expected = sorting.copy(list);
        Collections.sort(expected);
        ArrayList<Integer> actual = sorting.insertionSort(list);
        assertEquals(expected, actual);
    }

    /*
     * any algorithm could be chosen to run this test
     * for now it is set to counting sort
     */

    @Test // custom tests from file
    void customTest() {
        ReadTestCases cases = new ReadTestCases(
                "C:\\Users\\bo2dy\\OneDrive\\Documents\\GitHub\\Sorting-techniques\\test.txt");
        ArrayList<Integer> list = new ArrayList<>();
        try {
            list = cases.read().get(0);
        } catch (IOException e) {

            e.printStackTrace();
        }

        CountingSort countingSort = new CountingSort(list);
        int[] res = countingSort.returnFinalSorted();

        ArrayList<Integer> actual = new ArrayList<>();
        for (int i : res) {
            actual.add(i);
        }

        Collections.sort(list);
        assertEquals(list, actual);
    }

    @Test // time comparison between the three algorithms
    void timeComparisonTest() {

        Long startTime, endTime;
        ArrayList<Integer> list = randomList();
        System.out.println(list.size());

        // simple sort
        SimpleSort insertion = new SimpleSort();
        startTime = System.nanoTime();
        ArrayList<Integer> actual = insertion.insertionSort(list);
        endTime = System.nanoTime();
        System.out.println(
                "Time taken to sort the array using insertion sort: " + (endTime - startTime) / 1000 + " microseconds");

        // efficient sort
        EfficientSort merge = new EfficientSort();
        startTime = System.nanoTime();
        actual = merge.MergeSort(list, false);
        endTime = System.nanoTime();
        System.out.println(
                "Time taken to sort the array using merge sort: " + (endTime - startTime) / 1000 + " microseconds");

        // counting sort
        CountingSort countingSort = new CountingSort(list);
        startTime = System.nanoTime();
        int[] res = countingSort.returnFinalSorted();
        endTime = System.nanoTime();
        System.out.println(
                "Time taken to sort the array using counting sort: " + (endTime - startTime) / 1000 + " microseconds");
    }

    @Test // empty list test on isertion sort
    void emptyListTest() {
        SimpleSort sorting = new SimpleSort();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(list);
        ArrayList<Integer> actual = sorting.insertionSort(list);
        assertEquals(expected, actual);
    }

    @Test // single element list test on isertion sort
    void singleElementListTest() {
        SimpleSort sorting = new SimpleSort();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        ArrayList<Integer> expected = new ArrayList<>(list);
        ArrayList<Integer> actual = sorting.insertionSort(list);
        assertEquals(expected, actual);
    }

    @Test // Merge sort test in random case
    void mergeSortTest() {
        EfficientSort sorting = new EfficientSort();
        ArrayList<Integer> list = randomList();
        ArrayList<Integer> expected = new ArrayList<>(list);
        Collections.sort(expected);
        ArrayList<Integer> actual = sorting.MergeSort(list, false);
        assertEquals(expected, actual);
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
    void timeLimitTestCounting() {
        ArrayList<Integer> list = randomList();
        CountingSort countingSort = new CountingSort(list);
        ArrayList<Integer> expected = new ArrayList<>(list);
        Collections.sort(expected);
        int[] aux = countingSort.returnFinalSorted();
        ArrayList<Integer> actual = new ArrayList<>();
        for (int value : aux) {
            actual.add(value);
        }
        assertEquals(expected, actual);
    }

    @Test // random case for counting sort
    public void randomCountingSort() {
        ArrayList<Integer> list = randomList();
        CountingSort countingSort = new CountingSort(list);
        ArrayList<Integer> expected = new ArrayList<>(list);
        Collections.sort(expected);
        int[] aux = countingSort.returnFinalSorted();
        ArrayList<Integer> actual = new ArrayList<>();
        for (int value : aux) {
            actual.add(value);
        }

        assertEquals(expected, actual);
    }

}