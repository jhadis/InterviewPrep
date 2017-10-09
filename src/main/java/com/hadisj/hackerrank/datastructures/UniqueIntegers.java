package com.hadisj.hackerrank.datastructures;

import java.util.*;

/**
 * Created by admin on 8/13/17.
 */
public class UniqueIntegers {

    public static List<Integer> findUniqueIntegers(List<Integer> inputList) {
        List<Integer> uniqueList = new ArrayList<>();
        HashMap<Integer,Integer> uniqueMap = new HashMap<>();
        for (Integer integer: inputList) {
            if (uniqueMap.containsKey(integer)) {
                int val = uniqueMap.get(integer);
                val++;
                uniqueMap.put(integer, val);
            } else {
                uniqueMap.put(integer, 1);
            }
        }

        for (Map.Entry<Integer,Integer> entry: uniqueMap.entrySet()) {
            if (entry.getValue() == 1)
                uniqueList.add(entry.getKey());
        }

        return uniqueList;
    }

    public static List<Integer> findDistinctIntegers(List<Integer> inputList) {
        List<Integer> uniqueList = new ArrayList<>();
        HashSet<Integer> intSet = new HashSet<>();
        for (Integer integer: inputList) {
                intSet.add(integer);
        }

        for (Integer integer: intSet) {
                uniqueList.add(integer);
        }

        return uniqueList;
    }

    public static void main(String[] args) {
        List<Integer> testInputList = Arrays.asList(1,4,4,5,6,6);
        List<Integer> uniqueOutput = UniqueIntegers.findUniqueIntegers(testInputList);
        System.out.println(uniqueOutput);

        List<Integer> distinctOutput = UniqueIntegers.findDistinctIntegers(testInputList);
        System.out.println(distinctOutput);
    }
}
