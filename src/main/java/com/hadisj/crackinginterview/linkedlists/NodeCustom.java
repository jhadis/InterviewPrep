package com.hadisj.crackinginterview.linkedlists;

/**
 * Created by Jonathan on 2/15/2016.
 */
public class NodeCustom {

    String data = null;
    NodeCustom next = null;

    NodeCustom(String data, NodeCustom next) {
        this.data = data;
        this.next = next;
    }

    protected NodeCustom clone() {
        NodeCustom clonedNode = new NodeCustom(this.data, this.next);
        return clonedNode;
    }
}
