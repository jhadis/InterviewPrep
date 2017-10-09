package com.hadisj.crackinginterview.linkedlists;

import java.util.HashMap;

/**
 * Created by Jonathan on 2/15/2016.
 * Program to remove duplicates in a singly linked list
 */
public class RemoveDups {

    private LinkedListCustom listCustom = null;
    private NodeCustom n = null;
    private NodeCustom nPrev = null;
    private HashMap<String, Integer> stringOcurrencesMap = null;

    RemoveDups() {
        initialize();
    }

    private void initialize() {
        stringOcurrencesMap = new HashMap<String, Integer>();

        listCustom = new LinkedListCustom("a");
        n = listCustom.getFirstNode();
        n = listCustom.add("b");
        n = listCustom.add("a");
        n = listCustom.add("c");
        n = listCustom.add("f");
        n = listCustom.add("f");
        n = listCustom.add("f");
        n = listCustom.add("g");
        n = listCustom.add("h");
        n = listCustom.add("f");
        n = listCustom.add("i");
    }

    LinkedListCustom removeDuplicates() {
        NodeCustom tempNode = listCustom.getFirstNode();
        nPrev = null;

        while (tempNode != null) {
            if (stringOcurrencesMap.containsKey(tempNode.data)) {
                tempNode = listCustom.removeNode(tempNode, nPrev);
                int count = stringOcurrencesMap.get(tempNode.data);
                count++;
                stringOcurrencesMap.put(tempNode.data, new Integer(count));
            } else {
                stringOcurrencesMap.put(tempNode.data, 1);
            }
            nPrev = tempNode;
            tempNode = tempNode.next;
        }

        return this.listCustom;
    }

    public static void main(String args[]) {
        RemoveDups main = new RemoveDups();
        LinkedListCustom list = main.listCustom;
        list.printList();
        list = main.removeDuplicates();
        list.printList();
    }

}
