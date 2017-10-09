package com.hadisj.crackinginterview.stacksandqueues;

import java.util.ArrayList;

/**
 * Created by Jonathan on 2/20/2016.
 * From the Cracking the Coding Interview book.
 * Create a data structure that only allows a stack to grow till a certain threshold before a new stack
 * needs to be created internally.  The push and pop operations should appear normal to users of the data structure, but
 * the structure internally generates stacks as needed.
 *
 * This is the solution from the book.
 */
public class SetOfStacksRevised {
    public int threshold = 3;
    public StackNodeGeneric setHead;
    public ArrayList<Stack> stacks;

    SetOfStacksRevised() {
        stacks = new ArrayList<Stack>();
    }

    public StackNodeGenericRevised push(Object item) {
        if (stacks.size() == 0)
            stacks.add(new Stack(threshold));

        Stack lastStack = stacks.get(stacks.size()-1);
        if (lastStack.isFull()) {
            stacks.add(new Stack(threshold));
            lastStack = stacks.get(stacks.size()-1);
        }

        return lastStack.push(item);
    }

    public StackNodeGenericRevised pop() {
        if (stacks.size() == 0) {
            return null;
        }

        Stack lastStack = stacks.get(stacks.size()-1);
        StackNodeGenericRevised result = lastStack.pop();
        if (lastStack.isEmpty())
            stacks.remove(lastStack);
        return result;
    }

    public static void main(String[] args) {
        SetOfStacksRevised prog = new SetOfStacksRevised();
        prog.push(new Integer(10));
        prog.push(new Integer(11));
        prog.push(new Integer(12));
        prog.push(new Integer(1));
        StackNodeGenericRevised temp = prog.push(new Integer(1));
        StackNodeGenericRevised r = prog.pop();
        Integer result = (Integer)r.data;
        System.out.println(result);
        r = prog.pop();
        if (r != null) {
            result = (Integer)r.data;
            System.out.println(result);
        }
        temp = prog.push(new Integer(101));
        r = prog.pop();
        if (r != null) {
            result = (Integer)r.data;
            System.out.println(result);
        }
        r = prog.pop();
        if (r != null) {
            result = (Integer)r.data;
            System.out.println(result);
        }

    }

}


class StackNodeGenericRevised {
    StackNodeGenericRevised next;
    Object data;

    StackNodeGenericRevised() {

    }

    StackNodeGenericRevised(StackNodeGenericRevised node, Object item) {
        next = node;
        data = item;
    }

    StackNodeGenericRevised(Object item) {
        data = item;
    }
}

class Stack {
    StackNodeGenericRevised head = null;
    int capacity;
    int size;

    public Stack(int capacity) {
        this.capacity = capacity;
        size = 0;
    }

    boolean isFull() {
        return capacity == size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public StackNodeGenericRevised push(Object item) {
        if (head == null) {
            head = new StackNodeGenericRevised(item);
        } else {
            StackNodeGenericRevised t = new StackNodeGenericRevised(item);
            t.next = head;
            head = t;
        }
        size++;
        return head;
    }

    public StackNodeGenericRevised pop() {
        if (head == null) {
            return null;
        }
        size--;
        return head;
    }
}
