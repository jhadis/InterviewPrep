package com.hadisj.hackerrank.hbcdigital;

import java.util.Scanner;

/**
 * Created by Jonathan on 4/28/2016.
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result;

        for (int i = 1; i <= n; i++) {
            result = String.valueOf(i);
            if (i % 3 == 0) {
                result = "Fizz";
                if (i % 5 == 0) {
                    result += "Buzz";
                }
            } else if (i % 5 == 0) {
                result = "Buzz";
            }
            System.out.println(result);
        }
    }
}
