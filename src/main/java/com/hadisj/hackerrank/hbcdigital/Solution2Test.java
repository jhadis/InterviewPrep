package com.hadisj.hackerrank.hbcdigital;

/**
 * Created by Jonathan on 4/28/2016.
 */

import java.util.Arrays;

public class Solution2Test {

    static int index = -1;

    static int sum(int[] arr) {
        if (arr == null)
            return 0;

        index++;
        if (index != arr.length) {
            return arr[index] + sum(arr);
        } else
            return 0;
    }

    static int sum2(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        return arr[0] + sum(Arrays.copyOfRange(arr, 1,arr.length));
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3};
        //System.out.println(sum(array));
        System.out.println(sum2(array));
    }
}
