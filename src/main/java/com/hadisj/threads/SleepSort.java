package com.hadisj.threads;

/**
This is from the Square phone screen.

        SleepSort (A Horrible, Horrible Algorithm)

        Given some integers we want to sort, e.g. 3, 1, 5, 4, 2:

        * create a new thread for each integer
        * inside the thread, sleep for the integer's value
        * add the integer to a resulting collection

        Once all the threads are done running, the resulting collection
        will contain the integers in sorted order. (Can you explain how they end up sorted?)

        Let's implement! You're free to look up questions on Google, StackOverflow, etc.
        Imagine this is a normal work day, use all the tools available to you.

        Hint: get to running code first, iterate and improve afterwards.
        */

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepSort {

    class AddTheInt implements Runnable {

        List<Integer> list;
        int seconds;
        final int lowerBound;

        AddTheInt(List<Integer> list, Integer secs, Integer lowerBound) {
            this.list = list;
            this.seconds = secs;
            this.lowerBound = lowerBound * -1;
        }

        public void run() {
            try {
                Thread.sleep((seconds+lowerBound) * 1000);
            } catch (Exception e) {
            }


            list.add(seconds);
//            System.out.println(list);
        }

    }

    public List<Integer> sleepSortExecutorService(List<Integer> intList) {
        List<Integer> sortedList = Collections.synchronizedList(new ArrayList<Integer>());
        ExecutorService es = Executors.newCachedThreadPool();

        int lowestNumber = 0;
        int highestNumber = 0;
        for (Integer i: intList) {
            if (i < lowestNumber)
                lowestNumber = i;

            if (i > highestNumber)
                highestNumber = i;
        }

        for (Integer i: intList) {
            es.execute(new AddTheInt(sortedList, i, lowestNumber));
        }

        es.shutdown();

        try {
            boolean finished = es.awaitTermination(highestNumber + 10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sortedList;
    }

    public List<Integer> sleepSort(List<Integer> intList) throws Exception {

        List<Integer> sortedList = Collections.synchronizedList(new ArrayList<Integer>());
        List<Thread> threads = new ArrayList<Thread>();

        int lowestNumber = 0;
        for (Integer i: intList) {
            if (i < lowestNumber)
                lowestNumber = i;
        }

        for (Integer i: intList) {
            Thread t = new Thread(new AddTheInt(sortedList, i, lowestNumber));
            t.start();
            threads.add(t);
        }

        for (Thread t: threads) {
            t.join();
        }

        return sortedList;
    }

    public static void main(String[] args) {
        SleepSort app = new SleepSort();
        List<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(-1);
        integers.add(3);
        integers.add(2);
        integers.add(1);
        integers.add(0);
        integers.add(-2);
        System.out.println("Sort using low-level thread methods");
        try {
            List<Integer> result = app.sleepSort(integers);
            System.out.println("Result:");
            System.out.println(result);
        } catch (Exception e) {

        }

        System.out.println("Sort using ExecutorService methods");
        try {
            List<Integer> result = app.sleepSortExecutorService(integers);
            System.out.println("Result:");
            System.out.println(result);
        } catch (Exception e) {

        }

    }
}



