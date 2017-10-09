package com.hadisj.vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 7/7/17.
 * Custom implementation of a Vector (resizable array)
 */
public class MyVector {

    private Object[] underlyingArr;
    private int maxSize;
    private int currentSize;
    private double loadFactor = .05;

    public MyVector(int initialCapacity) {
        underlyingArr = new Object[initialCapacity];
        maxSize = initialCapacity;
    }

    public MyVector() {
        new MyVector(1000);
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int getSize() {
        return new Integer(currentSize);
    }

    public int getCapacity() {
        return new Integer(maxSize);
    }

    public Object[] getUnderlyingArr() {
        return Arrays.copyOf(underlyingArr, underlyingArr.length);
    }

    private boolean isAlmostFull() {
        return currentSize > (1.0 - loadFactor)*underlyingArr.length;
    }

    public void push(Object element) {
        if (isAlmostFull()) {
            resize();
        }
        underlyingArr[currentSize] = element;
        currentSize++;
    }

    public void insert(Object element, int index) {
        if (isAlmostFull()) {
            resize();
        }

        for (int i = currentSize - 1; i >= index; i--) {
            underlyingArr[i+1] = underlyingArr[i];
        }

        underlyingArr[index] = element;
        currentSize++;
    }

    public Object pop() {
        Object element = null;
        if (currentSize > 0) {
            element = underlyingArr[currentSize-1];
            underlyingArr[currentSize-1] = null;
            currentSize--;
        }
        return element;
    }

    public Object head() {
        Object result = null;
        if (currentSize > 0) {
            result = underlyingArr[0];
            this.delete(0);
        }

        return result;
    }

    public Object tail() {
        Object result = null;
        if (currentSize > 0) {
            result = underlyingArr[currentSize - 1];
            this.delete(currentSize - 1);
        }

        return result;
    }

    public void delete(int index) {
        shiftLeft(index);
    }

    private void shiftLeft(int index) {
        for (int i = index; i < currentSize; i++) {
            underlyingArr[i] = underlyingArr[i+1];
        }
        underlyingArr[currentSize] = null;
        currentSize--;
    }

    public void remove(Object element) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < currentSize; i++) {
            if (underlyingArr[i].equals(element)) {
                indices.add(i - indices.size());
            }
        }
        indices.forEach(index -> shiftLeft(index));
    }

    private void resize() {
        underlyingArr = Arrays.copyOf(underlyingArr, maxSize * 2);
        maxSize = maxSize * 2;
    }

    public static void main(String[] args) {
        MyVector vector = new MyVector(5);
        vector.push(new Integer(1));
        vector.push(new Integer(2));
        vector.push(new Integer(3));
        vector.push(new Integer(4));
        vector.push(new Integer(5));
        Object[] data = vector.getUnderlyingArr();
        for (Object elem : data) {
            System.out.println(elem);
        }
        System.out.println("Current size: " +vector.getSize());
        System.out.println("Capacity: " +vector.getCapacity());

        vector.pop();
        System.out.println(("Pop"));
        data = vector.getUnderlyingArr();
        for (Object elem : data) {
            System.out.println(elem);
        }
        System.out.println("Current size: " +vector.getSize());
        System.out.println("Capacity: " +vector.getCapacity());

        vector.push(new Integer(1));
        vector.push(new Integer(2));
        vector.push(new Integer(3));
        vector.push(new Integer(4));
        vector.push(new Integer(5));

        data = vector.getUnderlyingArr();
        for (Object elem : data) {
            System.out.println(elem);
        }
        System.out.println("Current size: " +vector.getSize());
        System.out.println("Capacity: " +vector.getCapacity());

        vector.insert(new Integer(10), 2);
        vector.insert(new Integer(10), 3);
        data = vector.getUnderlyingArr();
        for (Object elem : data) {
            System.out.println(elem);
        }
        System.out.println("Current size: " +vector.getSize());
        System.out.println("Capacity: " +vector.getCapacity());

//        vector.remove(new Integer(10));
        vector.delete(0);
        data = vector.getUnderlyingArr();
        for (Object elem : data) {
            System.out.println(elem);
        }
        System.out.println("Current size: " +vector.getSize());
        System.out.println("Capacity: " +vector.getCapacity());

        vector.remove(new Integer(10));
        data = vector.getUnderlyingArr();
        for (Object elem : data) {
            System.out.println(elem);
        }
        System.out.println("Current size: " +vector.getSize());
        System.out.println("Capacity: " +vector.getCapacity());

    }
}
