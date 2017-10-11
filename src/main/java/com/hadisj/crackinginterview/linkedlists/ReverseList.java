package com.hadisj.crackinginterview.linkedlists;

import java.util.LinkedList;

/**
 * Created by Jonathan on 4/17/2016.
 */
public class ReverseList {

    public ListNode reverseList(ListNode a) {
        if (a.next == null) {
            return a;
        }

        ListNode remaining = reverseList(a.next);
        a.next.next = a;
        a.next = null;
        return remaining;
    }

    public ListNode reverseListWithStack(ListNode node) {
        LinkedList<ListNode> stack = new LinkedList<>();

        while (node.next != null) {
            stack.push(node);
            node = node.next;
        }
        stack.push(node);

        //reverse the order
        ListNode resultRoot = stack.peek();
        while (!stack.isEmpty()) {
            ListNode current = stack.pop();
            if (!stack.isEmpty())
                current.next = stack.pop();
            else
                current.next = null;
        }

        return resultRoot;
    }
    public ListNode iterativeReverseList(ListNode node) {
        ListNode prevNode = null;
        ListNode nextNode = null;
        if (node != null) {
            while (node != null) {
                nextNode = node.next;
                node.next = prevNode;
                prevNode = node;
                node = nextNode;
            }
        }
        return prevNode;
    }

    public ListNode iterativeReverseList2(ListNode node) {
        ListNode prevNode = null;
        ListNode nextNode = null;

        if (node != null) {
            while (node != null) {
                nextNode = node.next;
                node.next = prevNode;
                prevNode = nextNode;
                node = nextNode;
            }
        }

        return prevNode;
    }

    public ListNode createList() {
        ListNode head = new ListNode();
        head.value = 3;
        ListNode nextNode = new ListNode();
        nextNode.value = 4;
        head.next = nextNode;
        ListNode nextNode2 = new ListNode();
        nextNode2.value = 5;
        nextNode.next = nextNode2;
        nextNode2.next = null;
        return head;
    }

    public void printList(ListNode listNode) {
        System.out.println("Linked list");
        while (listNode != null && listNode.next != null) {
            System.out.print(listNode.value + " => ");
            listNode = listNode.next;
        }
        if (listNode != null)
            System.out.println(listNode.value);
    }

    private class ListNode {
        int value;
        ListNode next;
    }

    public static void main(String... args) {
        ReverseList prog = new ReverseList();
        ListNode head = prog.createList();
        prog.printList(head);
        ListNode reversedHead = prog.reverseList(head);
        prog.printList(reversedHead);

        System.out.println("iterative");
        reversedHead = prog.iterativeReverseList(reversedHead);
        prog.printList(reversedHead);

//        reversedHead = prog.reverseListWithStack(reversedHead);
//        System.out.println("using stack");
//        prog.printList(reversedHead);
    }
}
