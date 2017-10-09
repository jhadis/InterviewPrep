package com.hadisj.crackinginterview.sorting;

/**
 * Created by Jonathan on 3/26/2016.
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {30,1,90,2};
        System.out.println("Unsorted array: ");
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        quicksort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (int i: arr) {
            System.out.print(i+ " ");
        }
    }

    private static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            quicksort(arr, start, pivotIndex - 1);
            quicksort(arr, pivotIndex+1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivotValue = arr[end];
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivotValue) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
