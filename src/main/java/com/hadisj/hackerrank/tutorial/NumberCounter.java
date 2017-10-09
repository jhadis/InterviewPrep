package com.hadisj.hackerrank.tutorial;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by admin on 9/18/17.
 */
public class NumberCounter {

    HashMap<Integer,Integer> countMap;
    int timeLimit;
    int maxNumber;

    NumberCounter(int timeLimitSecs, int maxNumber) {
        countMap = new HashMap<>();

        if (timeLimit >= 5)
            this.timeLimit = timeLimitSecs;
        else
            this.timeLimit = 5;

        if (maxNumber >= 10) {
            this.maxNumber = maxNumber;
        } else
            this.maxNumber = 10;

    }

    protected Map<Integer,Integer> run() {
        Random randomNumGenerator = new Random();
        long endTime = System.currentTimeMillis() + timeLimit * 1000;
        while (System.currentTimeMillis() <= endTime) {
            countMap.compute(randomNumGenerator.nextInt(this.maxNumber), (k, v) -> (v == null) ?
                    1 : v + 1);
        }

        return countMap;
    }


    public int findMostCommonInteger(Map<Integer, Integer> theMap) {
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : theMap.entrySet()) {
            if (maxEntry == null)
                maxEntry = entry;
            else if (entry.getValue() > maxEntry.getValue())
                maxEntry = entry;
        }

        return maxEntry.getKey();
    }

    private Map<Integer, Integer> printMap() {
        System.out.println(countMap);
        return countMap;
    }

    public static void main(String[] args) {
        NumberCounter app = new NumberCounter(5, 10);
        Map<Integer, Integer> map = app.run();
        Map<Integer, Integer> theMap = app.printMap();
        int mostCommon = app.findMostCommonInteger(theMap);
        System.out.println("The most common integer is: " +mostCommon);

        //Test findMostCommonInteger
        theMap.clear();
        theMap.put(1, 100);
        theMap.put(2, 100000);
        mostCommon = app.findMostCommonInteger(theMap);
        if (mostCommon == 2)
            System.out.println("Most common integer function test passed");
        else
            System.out.println("Most common integer function test failed");

    }
}
