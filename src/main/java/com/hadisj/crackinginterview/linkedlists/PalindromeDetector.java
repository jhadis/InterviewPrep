package com.hadisj.crackinginterview.linkedlists;

import java.util.Stack;

/**
 * Created by Jonathan on 2/15/2016.
 * Check if a linked list is a palindrome
 */
public class PalindromeDetector {

    LinkedListCustom listCustom = null;
    Stack<String> st = null;

    public PalindromeDetector() {
        st = new Stack<String>();
    }

    LinkedListCustom setList(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (i == 0) {
                listCustom = new LinkedListCustom(inputString.substring(i, i+1));
            } else {
                listCustom.add(inputString.substring(i, i+1));
            }
        }
        return listCustom;
    }

    boolean isPalindrome() {
        NodeCustom startOfSecondHalf = populateStack();
        boolean isEqual = compareStackTo2ndHalf(startOfSecondHalf);
        return isEqual;
    }

    private boolean compareStackTo2ndHalf(NodeCustom node) {
        while (!st.empty() && st.peek() != null) {
            String firstHalfNode = st.pop();
            if (!(node.data.equals(firstHalfNode))) {
                return false;
            } else {
                node = node.next;
            }
        }
        return true;
    }

    private NodeCustom populateStack() {
        int i = 1;
        NodeCustom node = listCustom.getFirstNode();
        while (node != null) {
            i++;
            node = node.next;
        }
        int midpoint = i/2;
        node = listCustom.getFirstNode();
        for (int j = 0; j < midpoint; j++) {
            st.add(node.data);
            node = node.next;
        }
        return node;
    }


    public static void main(String[] args) {
        PalindromeDetector main = new PalindromeDetector();
        main.setList("abba");
        main.listCustom.printList();
        System.out.println("Is this a palindrome? " +main.isPalindrome());
        main.setList("abbad");
        main.listCustom.printList();
        System.out.println("Is this a palindrome? " +main.isPalindrome());

    }
}
