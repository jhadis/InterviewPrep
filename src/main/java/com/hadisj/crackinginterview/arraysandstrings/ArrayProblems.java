package com.hadisj.crackinginterview.arraysandstrings;

/**
 * Created by admin on 7/5/17.
 */
public class ArrayProblems {

    /*
    From a sorted array, find the number that's repeated the most.
     */
    int numberWithLongestConsecutiveSubsequence(int[] arr) {
        int longestCount = 0;
        int longest = -100;
        int currentCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                longest = arr[i];
                longestCount = 1;
                currentCount = 1;
            } else if (arr[i] == arr[i-1]) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount >= longestCount) {
                longestCount = currentCount;
                longest = arr[i];
            }
        }

        System.out.println("The longest subsequence in the array is for " +longest+ " and it repeats " +longestCount+ " times.");
        return longest;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,2,2,3,4,5,5,6};
        ArrayProblems prog = new ArrayProblems();
        prog.numberWithLongestConsecutiveSubsequence(nums1);
    }
}
