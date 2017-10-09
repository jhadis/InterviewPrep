package com.hadisj.crackinginterview.stacksandqueues;

/**
 * Created by Jonathan on 2/20/2016.
 * From the Cracking the Coding Interview book.
 * Create a data structure that only allows a stack to grow till a certain threshold before a new stack
 * needs to be created internally.  The push and pop operations should appear normal to users of the data structure, but
 * the structure internally generates stacks as needed.
 */
public class SetOfStacks {
    public int threshold = 3;
    public StackNodeGeneric setHead;

    public StackNodeGeneric push(Object item) {
        if (setHead == null) {
            setHead = new StackNodeGeneric();
            setHead.data = new StackNodeGeneric(item);
            StackNodeGeneric newItem = (StackNodeGeneric)setHead.data;
            newItem.count = 1;
        } else {
            StackNodeGeneric t = (StackNodeGeneric)setHead.data;
            if (t.count == threshold) {
                //Add a new stack
                StackNodeGeneric t2 = new StackNodeGeneric();
                t2.next = t;
                setHead = t2;
            }
            //Push the content into the top stack
            t = (StackNodeGeneric)setHead.data;
            StackNodeGeneric itemToAdd = new StackNodeGeneric(item);
            if (t == null) {
                setHead.data = itemToAdd;
                itemToAdd.count = 1;
            }
            else {
                itemToAdd.next = t;
                itemToAdd.count = t.count++;
                setHead.data = itemToAdd;
            }
        }
        return setHead;
    }

    public StackNodeGeneric pop() {
        if (setHead == null) {
            return null;
        }

        StackNodeGeneric sn = (StackNodeGeneric)setHead.data;
        //StackNodeGeneric data = (StackNodeGeneric)sn.data;
        if (sn.next != null)
            setHead.data = sn.next;
        else {
            //Move to next stack
            setHead = setHead.next;
        }
        StackNodeGeneric result = sn;
        return result;
    }

    public static void main(String[] args) {
        SetOfStacks prog = new SetOfStacks();
        prog.push(new Integer(10));
        prog.push(new Integer(11));
        prog.push(new Integer(12));
        prog.push(new Integer(1));
        StackNodeGeneric temp = prog.push(new Integer(1));
        StackNodeGeneric r = prog.pop();
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


class StackNodeGeneric {
    StackNodeGeneric next;
    Object data;
    int count;

    StackNodeGeneric() {

    }

    StackNodeGeneric(StackNodeGeneric node, Object item) {
        next = node;
        data = item;
    }

    StackNodeGeneric(Object item) {
        data = item;
    }
}
