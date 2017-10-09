package com.hadisj.crackinginterview.stacksandqueues;

/**
 * Created by Jonathan on 2/20/2016.
 * Problem from Cracking the Coding Interview
 * How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element?  Push, pop, and min all operate in O(1) time.
 */
public class StackMin {
    StackNode top = null;

    public StackNode push(StackNode item) {
        if (top != null) {
            if (item.data <= top.currentMin) {
                item.currentMin = item.data;
            } else {
                item.currentMin = top.currentMin;
            }
            item.next = top;
            top = item;
        } else {
            top = item;
            item.currentMin = item.data;
            item.next = null;
        }
        return item;
    }

    public StackNode pop() {
        if (top != null) {
            StackNode temp = top;
            top = top.next;
            return temp;
        }
        return null;
    }

    public int min() {
        return top.currentMin;
    }

    public static void main(String[] args) {
        StackMin sm = new StackMin();
        StackNode temp = new StackNode(10);
        sm.push(temp);
        temp = new StackNode(3);
        sm.push(temp);
        temp = new StackNode(1);
        sm.push(temp);
        System.out.println(sm.min());
        System.out.println("Popped: " +sm.pop().data);
        System.out.println(sm.min());
    }


}

class StackNode {
    StackNode next;
    int data;
    int currentMin;

    StackNode(int num) {
        data = num;
    }
}

