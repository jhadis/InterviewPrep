package com.hadisj.crackinginterview.linkedlists;

/**
 * Created by Jonathan on 2/15/2016.
 */
public class LinkedListCustom {

    private NodeCustom firstNode = null;


    LinkedListCustom(String data) {
        this.firstNode = new NodeCustom(data, null);
    }

    NodeCustom getFirstNode() {
        /*NodeCustom n = new NodeCustom(new String(firstNode.data), firstNode.next);
        return n;*/
        return this.firstNode;
    }

    NodeCustom add(String newValue) {
        NodeCustom tempNode = this.firstNode;
        //Find the last node
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        //Add the new node to the end
        NodeCustom newNode = new NodeCustom(newValue, null);
        tempNode.next = newNode;

        return newNode;
    }

    NodeCustom addAfterNode(NodeCustom node, String data) {
        //Add the new node to the end
        NodeCustom newNode = new NodeCustom(data, node.next);
        node.next = newNode;
        return newNode;
    }

    NodeCustom removeNode(NodeCustom nodeToRemove, NodeCustom previousNode) {
        previousNode.next = nodeToRemove.next;
        nodeToRemove.next = null;
        return previousNode;
    }

    void printList() {
        NodeCustom tempNode = this.firstNode;
        printList(tempNode);
    }

    void printList(NodeCustom head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(", ");
            else
                System.out.print("\n");
            head = head.next;
        }
    }
}
