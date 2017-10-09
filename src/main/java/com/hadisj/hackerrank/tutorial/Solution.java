package com.hadisj.hackerrank.tutorial;

/**
 * Created by Jonathan on 4/26/2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws java.io.IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //if (args != null && args[0] != null) {
        //int n = System.in.read();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        boolean foundResult = false;
        int numerator = 1;
        char[] digits = null;

        while (!foundResult || numerator <= 30000) {
            if (numerator % n == 0) {
                //Check sum of digits
                digits = String.valueOf(numerator).toCharArray();
                int sum = 0;
                for (char c : digits) {
                    int digit = Character.getNumericValue(c);
                    sum += digit;
                }
//                if (digits.length >= (numerator * n))
//                    foundResult = true;
                if (sum >= (numerator * n)) {
                    foundResult = true;
                    break;
                }
            }
            numerator++;
        }
        System.out.println(digits.length);
    }
}