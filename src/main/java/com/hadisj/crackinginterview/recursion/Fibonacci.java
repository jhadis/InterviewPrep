package com.hadisj.crackinginterview.recursion;

/**
 * Created by admin on 10/3/17.
 */
public class Fibonacci {

    /**
     * Fibonacci series starts with 0 and 1 and continues xn = xn-1 + xn-2
     * @param limit
     * @return
     */
    public static int fibonacciSum(int position) {
        if (position == 1)
            return 0;
        else if (position == 2)
            return 1;
        else {
            return fibonacciSum(position - 1) + fibonacciSum(position - 2);
        }

    }

    public static void main(String[] args) {
        System.out.println("Fibonacci sum for 7: "+ fibonacciSum(7));
    }
}
