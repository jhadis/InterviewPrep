package com.hadisj.hackerrank.datastructures;

import java.util.Scanner;

/**
 * Created by Jonathan on 4/26/2016.
 * See https://www.hackerrank.com/challenges/array-and-simple-queries
 */
public class ArrayTransposer {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int arraySize = s.nextInt();
        int queries = s.nextInt();
        int[] arr = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            int arrayVal = s.nextInt();
            arr[i] = arrayVal;
        }

        int[] transposedArray = new int[arr.length];
        transposedArray = arr;

        for (int i = 1; i <= queries; i++) {
            int queryType = s.nextInt();
            int startIndex = s.nextInt();
            int endIndex = s.nextInt();

            transposedArray = transpose(transposedArray, startIndex, endIndex, queryType);
        }

        int diff = transposedArray[0] - transposedArray[transposedArray.length-1];
        int absVal = Math.abs(diff);
        System.out.println(absVal);
        for (int i = 0; i < transposedArray.length; i++) {
            System.out.print(transposedArray[i]+ " ");
        }
    }

    static int[] transpose(int[] arr, int startIndex, int endIndex, int queryType) {
        startIndex -= 1;
        endIndex -= 1;
        int[] outputArr = new int[arr.length];

        //Transplant items from startIndex to endIndex.  Put at the beginning of the array
        if (queryType == 1) {
            int outIndex = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                outputArr[outIndex] = arr[i];
                    outIndex++;
            }
            //int index = outIndex + 1;
            for (int j = 0; j < arr.length; j++) {
                if (j < startIndex || j > endIndex) {
                    outputArr[outIndex] = arr[j];
                    outIndex++;
                }
            }

         //Transplant items from startIndex to endIndex.  Put at the end of the array
        } else if (queryType == 2) {
            int outIndex = arr.length - (endIndex - startIndex) - 1;
            for (int i = startIndex; i <= endIndex; i++) {
                outputArr[outIndex] = arr[i];
                outIndex++;
            }
            int index = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j < startIndex || j > endIndex) {
                    outputArr[index] = arr[j];
                    index++;
                }
            }
        }
        return outputArr;
    }
}
