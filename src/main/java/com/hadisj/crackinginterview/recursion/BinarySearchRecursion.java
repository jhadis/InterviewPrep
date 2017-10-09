package com.hadisj.crackinginterview.recursion;

/**
 * Created by Jonathan on 4/28/2016.
 */
public class BinarySearchRecursion {

    int findPositionOf(int searchItem, int[] arr, int startIndex, int endIndex) {
        int result = -1;
        int midpt = (endIndex + startIndex)/2;

        if (startIndex >= endIndex)
            return -1;

        if (startIndex >= endIndex)
            return -1;

        if (searchItem == arr[midpt]) {
            return midpt;
        } else if (searchItem < arr[midpt]) {
            return findPositionOf(searchItem, arr, startIndex, midpt);
        } else {
            return findPositionOf(searchItem, arr, midpt+1, endIndex);
        }
    }

    public static void main(String[] args) {
        BinarySearchRecursion prog = new BinarySearchRecursion();
        int[] t1 = new int[] {1, 2, 4, 10};
        int result = prog.findPositionOf(4, t1, 0, t1.length - 1);
        System.out.println(result);
        result = prog.findPositionOf(201, t1, 0, t1.length-1);
        System.out.println(result);
    }
}
