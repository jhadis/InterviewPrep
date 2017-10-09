package com.hadisj.crackinginterview.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 7/8/17.
 */
public class MyQueue3 {

    private Object[] underlyingArray;
    private List<Object> underlyingList;
    private int startPos = 0;
    private int size = 0;

    MyQueue3() {
        //underlyingArray = new Object[2];
        underlyingList = new ArrayList<>();

    }

    public void enqueue(Object element) {
//        if (size >= underlyingArray.length)
//            resizeArray();
//        underlyingArray[size] = element;
//        size++;
        underlyingList.add(element);
    }

    private void resizeArray() {
        System.out.println("resizing array");
        this.underlyingArray = Arrays.copyOf(underlyingArray,underlyingArray.length*2);
    }

    public Object dequeue() {
//        Object result = underlyingArray[startPos];
//        if (result != null) {
//            startPos++;
//            size--;
//        }
        Object result = null;
        if (underlyingList.size() > 0) {
            result = underlyingList.get(0);
            underlyingList.remove(0);
        }
        return result;
    }

    public void clear() {
//        for (int i = 0; i < underlyingArray.length; i++) {
//            underlyingArray[i] = null;
//        }
//        startPos = 0;
//        size = 0;
        underlyingList.clear();
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyQueue3 queue = new MyQueue3();

        queue.enqueue(new Integer(1));
        queue.enqueue(new Integer(2));
        queue.enqueue(new Integer(3));
        queue.enqueue(new Integer(4));
        queue.enqueue(new Integer(5));
        System.out.println("Size of queue: " +queue.size());

        System.out.println("Dequeue");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println("Clear the queue");
        queue.clear();
        System.out.println("Size of queue: " +queue.size());
        System.out.println(queue.dequeue());

        queue.enqueue(new Integer(1));
        queue.enqueue(new Integer(2));
        queue.enqueue(new Integer(3));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
