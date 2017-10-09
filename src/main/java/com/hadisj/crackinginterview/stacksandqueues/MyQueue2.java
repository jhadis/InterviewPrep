package com.hadisj.crackinginterview.stacksandqueues;

import java.util.Arrays;

/**
 * Created by admin on 7/8/17.
 */
public class MyQueue2 {

    private Object[] underlyingArray;
    private int startPos = 0;
    private int size = 0;

    MyQueue2() {
        underlyingArray = new Object[2];

    }

    public void enqueue(Object element) {
        if (size >= underlyingArray.length)
            resizeArray();
        underlyingArray[size] = element;
        size++;
    }

    private void resizeArray() {
        System.out.println("resizing array");
        this.underlyingArray = Arrays.copyOf(underlyingArray,underlyingArray.length*2);
    }

    public Object dequeue() {
        Object result = underlyingArray[startPos];
        if (result != null) {
            startPos++;
            size--;
        }
        return result;
    }

    public void clear() {
        for (int i = 0; i < underlyingArray.length; i++) {
            underlyingArray[i] = null;
        }
        startPos = 0;
        size = 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyQueue2 queue = new MyQueue2();

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
    }
}
