package com.hadisj.crackinginterview.graphs;

import java.util.LinkedList;

/**
 * Created by Jonathan on 2/25/2016.
 */
public class GraphSearch {
    private GraphNode root = null;

    void depthFirstSearch(GraphNode node) {
        visit(node);
        node.visited = true;

        if (node.getAdjacent() != null) {
            for (GraphNode n : node.getAdjacent()) {
                if (n.visited == false) {
                    depthFirstSearch(n);
                }
            }
        }
    }

    private void visit(GraphNode node) {
        System.out.println(node.getValue());
    }

    void breadthFirstSearch(GraphNode root) {
        root.visited = true;
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            GraphNode n = queue.removeFirst();
            visit(n);

            if (n.getAdjacent() != null) {
                for (GraphNode elem : n.getAdjacent()) {
                    if (elem.visited == false) {
                        queue.add(elem);
                        elem.visited = true;
                    }
                }
            }
        }
    }

    GraphNode breadthFirstSearchForValue(GraphNode root, String searchTerm) {
        root.visited = true;
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            GraphNode n = queue.removeFirst();
            if (n.getValue().equals(searchTerm))
                return n;

            if (n.getAdjacent() != null) {
                for (GraphNode elem : n.getAdjacent()) {
                    if (elem.visited == false) {
                        queue.add(elem);
                        elem.visited = true;
                    }
                }
            }
        }

        return null;
    }

    /**
     * From Cracking the Coding Interview, chapter 4
     * Problem 4.1: Route Between Nodes.  Given a directed graph, design an algorithm to find out
     * whether there is a route between two nodes.
     * @param val1
     * @param val2
     * @return
     */
    boolean isThereRouteBetweenNodes(GraphNode root, String val1, String val2) {
        resetVisitedStateToFalse(this.root);
        GraphNode node1 = breadthFirstSearchForValue(root, val1);
        if (node1 == null) {
            return false;
        }

        resetVisitedStateToFalse(this.root);
        GraphNode target2 = breadthFirstSearchForValue(node1, val2);
        if (target2 != null) {
            return true;
        }

        resetVisitedStateToFalse(this.root);
        GraphNode node2 = breadthFirstSearchForValue(root, val2);
        if (node2 == null) {
            return false;
        }

        resetVisitedStateToFalse(this.root);
        GraphNode target1 = breadthFirstSearchForValue(node2, val1);
        if (target1 != null) {
            return true;
        }

        return false;
    }


    void setup() {
        GraphNode child1 = new GraphNode("6");
        GraphNode temp = new GraphNode("3");
        GraphNode child2 = new GraphNode("4");
        temp.setAdjacent(new GraphNode[]{child1, child2});
        child2.setAdjacent(new GraphNode[]{child1});
        root = new GraphNode("1");
        root.setAdjacent(new GraphNode[]{temp});
    }

    void setup2() {
        root = new GraphNode("1");
        GraphNode node4 = new GraphNode("4");
        GraphNode node7 = new GraphNode("7");
        GraphNode node9 = new GraphNode("9");
        GraphNode node10 = new GraphNode("10");
        GraphNode node5 = new GraphNode("5");

        root.setAdjacent(new GraphNode[]{node4, node7, node5});
        node4.setAdjacent(new GraphNode[]{node7});
        node7.setAdjacent(new GraphNode[]{node9});
        node9.setAdjacent(new GraphNode[]{node5, node10});
        node5.setAdjacent(new GraphNode[]{node10});



    }

    void resetVisitedStateToFalse(GraphNode node) {
        node.visited = false;

        if (node.getAdjacent() != null) {
            for (GraphNode n : node.getAdjacent()) {
                if (n.visited == true) {
                    resetVisitedStateToFalse(n);
                }
            }
        }
    }



    public static void main(String[] args) {
        GraphSearch prog = new GraphSearch();
        prog.setup();
        //GraphNode result = prog.depthFirstSearch(prog.root, "4");
        prog.depthFirstSearch(prog.root);
        prog.resetVisitedStateToFalse(prog.root);
        System.out.println("Breadth-first search BEGIN");
        prog.breadthFirstSearch(prog.root);
        System.out.println("Route between 2 nodes BEGIN");
        prog.resetVisitedStateToFalse(prog.root);
        boolean result = prog.isThereRouteBetweenNodes(prog.root, "1", "6");
        System.out.println("Route between 1 and 6: " + result);
        result = prog.isThereRouteBetweenNodes(prog.root, "6", "1");
        System.out.println("Route between 6 and 1: " +result);
        result = prog.isThereRouteBetweenNodes(prog.root, "3", "6");
        System.out.println("Route between 3 and 6: " +result);
        result = prog.isThereRouteBetweenNodes(prog.root, "6", "81");
        System.out.println("Route between 6 and 81: " +result);

        System.out.println("Use a new graph");
        System.out.println("------------------------------");
        System.out.println("Breadth-first search (BFS) - BEGIN");
        prog.setup2();
        prog.breadthFirstSearch(prog.root);
        System.out.println("Breadth-first search (BFS) - END");

    }
}
