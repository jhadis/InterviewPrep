package com.hadisj.crackinginterview.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 2/25/2016.
 */
public class TraversalAndInsertion {
    private TreeNode root;

    void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            visit(node);
            inOrderTraversal(node.getRight());
        }
    }

    void preOrderTraversal(TreeNode node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            visit(node);
        }
    }

    private void visit(TreeNode node) {
        System.out.println(node.value);
    }

    void setupBinaryTree() {
        ArrayList<Integer> numbers = new ArrayList();
        //20, 10, 43, 1, 22, 51
        numbers.add(20);
        numbers.add(10);
        numbers.add(43);
        numbers.add(1);
        numbers.add(22);
        numbers.add(51);
        for (Integer i : numbers) {
            insertIntoBinarySearchTree(i);
        }
    }

    private void insertIntoBinarySearchTree(int data) {
        if (root == null) {
            TreeNode node = new TreeNode(data);
            root = node;
        } else {
            TreeNode node = new TreeNode(data);
            insertData(node, root);
        }
    }

    private void insertData(TreeNode node, TreeNode parent) {
        if (Integer.compare(node.value, parent.value) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            } else {
                insertData(node, parent.getLeft());
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(node);
            } else {
                insertData(node, parent.getRight());
            }
        }

    }

    public List<TreeNode> getNodesFromLevel(TreeNode root, int level) {
        List<TreeNode> nodes = new ArrayList<>();
        traverseTree(root, 1, level, nodes);
        return nodes;
    }

    private void traverseTree(TreeNode root, int currentLevel, int targetLevel, List<TreeNode> nodes) {
        if (root == null)
            return;

        traverseTree(root.getLeft(), currentLevel + 1, targetLevel, nodes);
        //visit section
        if (currentLevel == targetLevel)
            nodes.add(root);
        traverseTree(root.getRight(), currentLevel + 1, targetLevel, nodes);
    }

    void traverseTree(TreeNode root) {
         if (root == null)
             return;

        traverseTree(root.getLeft());
        visit(root);
        traverseTree(root.getRight());
    }

    public static void main(String[] args) {
        TraversalAndInsertion prog = new TraversalAndInsertion();
        prog.setupBinaryTree();
        System.out.println("In-order Traversal - BEGIN");
        prog.inOrderTraversal(prog.root);
        System.out.println("In-order Traversal - END");
        System.out.println("Pre-order Traversal - BEGIN");
        prog.preOrderTraversal(prog.root);
        System.out.println("Pre-order Traversal - END");
        System.out.println("Post-order Traversal - BEGIN");
        prog.postOrderTraversal(prog.root);
        System.out.println("Post-order Traversal - END");

        System.out.println("Jon's traversal - BEGIN");
        prog.traverseTree(prog.root);
        System.out.println("Jon's traversal - END");

        System.out.println("Show all nodes at level 2: ");
        List<TreeNode> nodes = prog.getNodesFromLevel(prog.root, 2);
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(nodes.get(i).value);
            if (i < nodes.size() - 1)
                System.out.print(", ");
        }
    }
}
