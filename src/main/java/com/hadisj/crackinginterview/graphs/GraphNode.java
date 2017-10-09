package com.hadisj.crackinginterview.graphs;

/**
 * Created by Jonathan on 2/25/2016.
 */
public class GraphNode {
    String value;
    GraphNode[] adjacent = null;
    boolean visited = false;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public GraphNode[] getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(GraphNode[] adjacent) {
        this.adjacent = adjacent;
    }

    public GraphNode(String value) {
        this.value = value;
    }
}
