package com.hadisj.crackinginterview.linkedlists;

import javax.xml.soap.Node;
import java.util.Stack;

/**
 * Created by Jonathan on 2/15/2016.
 * Check if a linked list is a palindrome
 * Solution 1 from Cracking the Coding Interview
 */
public class PalindromeDetectorSolution1 {

    LinkedListCustom listCustom = null;
    Stack<String> st = null;

    public PalindromeDetectorSolution1() {
        st = new Stack<String>();
    }

    NodeCustom setList(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (i == 0) {
                listCustom = new LinkedListCustom(inputString.substring(i, i+1));
            } else {
                listCustom.add(inputString.substring(i, i+1));
            }
        }
        return listCustom.getFirstNode();
    }

    boolean isPalindrome(NodeCustom head) {
        HeadAndTail reversed = reverse(head);
        NodeCustom reversedHead = reversed.head;
        return isEqual(head, reversedHead);
    }

    private boolean isEqual(NodeCustom one, NodeCustom two) {
        NodeCustom head1 = one;
        NodeCustom head2 = two;
        while (head1 != null && head2 != null) {
            if (!head1.data.equals(head2.data)) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    HeadAndTail reverse(NodeCustom head) {
        if (head == null)
            return null;
        HeadAndTail ht = reverse(head.next);
        NodeCustom clonedHead = head.clone();
        clonedHead.next = null;

        if (ht == null) {
            return new HeadAndTail(clonedHead, clonedHead);
        }
        ht.tail.next = clonedHead;
        return new HeadAndTail(ht.head, clonedHead);
    }

    NodeCustom reverseSimple(NodeCustom head) {
        if (head == null)
            return null;

        NodeCustom node = head;
        NodeCustom prevNode = null;
        NodeCustom nextNode;

       while (node != null) {
           nextNode = node.next;
           node.next = prevNode;
           prevNode = node;
           node = nextNode;
       }

        head = prevNode;

        return head;
    }


    public static void main(String[] args) {
        PalindromeDetectorSolution1 main = new PalindromeDetectorSolution1();
        NodeCustom head = main.setList("abba");
        main.listCustom.printList();
        System.out.println("Is this a palindrome? " +main.isPalindrome(head));
        head = main.setList("abbad");
        main.listCustom.printList();
        System.out.println("Is this a palindrome? " +main.isPalindrome(head));

        head = main.setList("abbad");
        head = main.reverseSimple(head);
        main.listCustom.printList(head);

    }

    class HeadAndTail {
        public NodeCustom head;
        public NodeCustom tail;

        public HeadAndTail(NodeCustom h, NodeCustom t) {
            head = h;
            tail = t;
        }
    }
}
