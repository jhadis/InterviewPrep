package com.hadisj.crackinginterview.linkedlists;

/**
 * Created by admin on 9/25/17.
 */
public class LinkedListProblems {

    /**
     * Checks if the linked list has a cycle.  Accomplishes this by advancing two pointers.  One of the pointers advances
     * at twice the speed of the other.  If the fast one laps the other, then there is a cycle.  It laps it if
     * slow and fast pointers ever point to the same node.
     * @param head
     * @return
     */
    public static boolean hasCycle(NodeCustom head) {
        NodeCustom fast = head;
        NodeCustom slow = head;

        while (fast != null && slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * NOT WORKING
     * @param list
     * @param position1
     * @param position2
     * @return
     */
    public static LinkedListCustom swapNodes(LinkedListCustom list, int position1, int position2) {
        int counter = 1;
        NodeCustom prevNode1 = null;
        NodeCustom prevNode2 = null;
        boolean foundPosition1 = false;
        boolean foundPosition2 = false;

        NodeCustom node = list.getFirstNode();

        while (node != null) {
            if (counter < position1)
                prevNode1 = node;

            if (counter < position2)
                prevNode2 = node;
            node = node.next;
            counter++;
        }

        if (position1 == 1 && prevNode2 != null) {
            NodeCustom firstNode = list.getFirstNode();
        } else if (prevNode1 != null && prevNode2 != null) {
            NodeCustom node1 = prevNode1.next;
            NodeCustom node2 = prevNode2.next;

            NodeCustom nextNode = node1.next;
            node1.next = node2.next;
            node2.next = nextNode;
        }

        return list;
    }

    public static void main(String[] args) {
        LinkedListCustom list = new LinkedListCustom("a");
        NodeCustom firstNode = list.getFirstNode();
        list.add("b");
        list.add("c");
        NodeCustom node = list.add("d");
        //create a cycle
        node.next = firstNode;

        System.out.println("Is there a cycle? " +LinkedListProblems.hasCycle(firstNode));

        list = new LinkedListCustom("a");
        firstNode = list.getFirstNode();
        list.add("b");
        list.add("c");
        node = list.add("d");
//        list = LinkedListProblems.swapNodes(list, 1, 3);  not working
        list.printList();

    }
}
