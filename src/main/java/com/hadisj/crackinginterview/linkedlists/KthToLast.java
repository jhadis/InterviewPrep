package com.hadisj.crackinginterview.linkedlists;

/**
 * Created by Jonathan on 2/15/2016.
 * This program will return the Kth to last element in a singly linked list.
 */
public class KthToLast {

    LinkedListCustom listCustom = null;

    KthToLast() {
        initialize();
    }

    private void initialize() {
        listCustom = new LinkedListCustom("a");
        listCustom.getFirstNode();
        listCustom.add("b");
        listCustom.add("a");
        listCustom.add("c");
        listCustom.add("f");
        listCustom.add("f");
        listCustom.add("f");
        listCustom.add("g");
        listCustom.add("h");
        listCustom.add("f");
        listCustom.add("i");
    }

    NodeCustom getKthToLast(int distanceFromLast) throws Exception {
        NodeCustom n = listCustom.getFirstNode();
        int length = 0;
        while (n != null) {
            length++;
            n = n.next;
        }

        int positionOfSelectedNode = length - 2 - distanceFromLast;
        NodeCustom selectedNode = listCustom.getFirstNode();

        if (positionOfSelectedNode > 0) {
            for (int i = 0; i < positionOfSelectedNode; i++) {
                selectedNode = selectedNode.next;
            }
        } else {
            throw new Exception("Too far from end of list.  The list isn't this big");
        }
        return selectedNode;
    }

    int printRecursiveKthToLast(int distanceFromLast, NodeCustom headNode) {
        if (headNode == null) {
            return -2;
        }

        int index = printRecursiveKthToLast(distanceFromLast, headNode.next) + 1;
        if (index == distanceFromLast) {
            System.out.println(distanceFromLast+ "th from last node is " +headNode.data);
        }

        return index;
    }

    public static void main(String[] args) {
        KthToLast main = new KthToLast();
        main.listCustom.printList();
        try {
            System.out.println("Get the 3rd from last: " +main.getKthToLast(3).data);
            System.out.println("Get the 6th from last: " +main.getKthToLast(6).data);

            System.out.println("RECURSIVE SOLUTION");
            main.listCustom.printList();
            main.printRecursiveKthToLast(3, main.listCustom.getFirstNode());
            main.printRecursiveKthToLast(6, main.listCustom.getFirstNode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
