package com.hadisj.crackinginterview.stacksandqueues;

import com.hadisj.vectors.MyVector;

/**
 * Created by admin on 7/8/17.
 */
public class MyQueue {

    private MyVector underlyingVector;

    MyQueue() {
        underlyingVector = new MyVector(1000);
    }

    public void enqueue(Object element) {
        underlyingVector.push(element);
    }

    public Object dequeue() {
        return underlyingVector.head();
    }

    public void clear() {
        while (underlyingVector.pop() != null) {}
        return;
    }

    public int size() {
        return underlyingVector.getSize();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

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
