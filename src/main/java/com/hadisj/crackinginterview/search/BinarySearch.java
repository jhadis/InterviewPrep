package com.hadisj.crackinginterview.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jonathan on 4/17/2016.
 */
public class BinarySearch {

    /**
     * Count the number of occurrences of a value in a list
     * @param a
     * @param b
     * @return
     */
    public int findCount(final List<Integer> a, int b) {
        int result = 0;
    /*while (findCount(a, b) != -1) {
        result++;
    } */

        int end = a.size()-1;

        for (int start = 0; start <= end; start++) {
            int innerStart = start, innerEnd = end;
            while (innerStart <= end) {
                int midpt = (innerEnd - innerStart) / 2;
                if (a.get(midpt) == b) {
                    result++;
                    break;
                }
                else if (b < a.get(midpt))
                    innerEnd = midpt -1;
                else
                    innerStart = midpt + 1;
            }
        }
        return result;
    }

    public static void main(String... args) {
        BinarySearch prog = new BinarySearch();
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,2,3));
        System.out.println(prog.findCount(list,2));
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(2));
        System.out.println(prog.findCount(list2,2));
    }
}
