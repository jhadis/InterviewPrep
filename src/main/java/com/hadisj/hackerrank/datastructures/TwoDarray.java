package com.hadisj.hackerrank.datastructures;

import java.util.Scanner;

/**
 * Created by Jonathan on 4/26/2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class TwoDarray {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        int maxSum = Integer.MIN_VALUE;

        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        int sum = 0;

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                sum += arr[i][j];
                sum += arr[i][j+1];
                sum += arr[i][j+2];
                sum += arr[i+1][j+1];
                sum += arr[i+2][j];
                sum += arr[i+2][j+1];
                sum += arr[i+2][j+2];

                if (sum > maxSum)
                    maxSum = sum;
                sum = 0;
            }
        }
        System.out.println(maxSum);
    }

}
