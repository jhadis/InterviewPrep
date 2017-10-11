package com.hadisj.crackinginterview.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jonathan on 2/27/2016.
 */
public class TreeProblems {

//    TreeNode root = null;
    /**
     * Check if a binary tree is balanced.  The height of the left subtree's height must be equal to
     * or within 1 of the right subtree's height.  It's best to use pre-order traversal and
     *
     * @param root
     * @return
     */

    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }

    boolean checkBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }

        int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight());
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return checkBalanced(root.getLeft()) && checkBalanced(root.getRight());
        }
    }

    TreeNode setupTree(Integer[] nums) {
        List<Integer> numbers = Arrays.asList(nums);
        //20, 10, 43, 1, 22, 51
//        numbers.add(20);
//        numbers.add(10);
//        numbers.add(43);
//        numbers.add(1);
//        numbers.add(22);
//        numbers.add(51);
        TreeNode root = null;
        for (Integer i : numbers) {
            root = insertIntoBinarySearchTree(i, root);
            root = insertIntoBinarySearchTree(i, root);
        }
        return root;
    }

    private TreeNode insertIntoBinarySearchTree(int data, TreeNode root) {
        if (root == null) {
//            TreeNode node = new TreeNode(data);
            root = new TreeNode(data);
        } else {
            TreeNode node = new TreeNode(data);
            insertData(node, root);
        }
        return root;
    }

    private void insertData(TreeNode node, TreeNode parent) {
        if (Integer.compare(node.value, parent.value) < 0) {
            if (parent.getLeft() == null) {
                node.setParent(parent);
                parent.setLeft(node);
            } else {
                insertData(node, parent.getLeft());
            }
        } else {
            if (parent.getRight() == null) {
                node.setParent(parent);
                parent.setRight(node);
            } else {
                insertData(node, parent.getRight());
            }
        }
    }

    private TreeNode findNodeByData(int data, TreeNode node) {
        if (node == null)
            return null;

        findNodeByData(data, node.getLeft());
        if (node != null && node.value == data) {
            return node;
        }

        findNodeByData(data, node.getRight());

        return null;
    }

//    private boolean deleteData(int data, TreeNode root) {
//        TreeNode node = findNodeByData(data, root);
//
//        if (node != null) {
//            return deleteData(node);
//        }
//
//        return false;
//    }

//    private boolean deleteData(TreeNode node) {
//        if (node != null) {
//            if (node.getLeft() == null && node.getRight() == null) {
//                if (node.getParent().getRight().equals(node)) {
//                    node.getParent().setRight(null);
//                    return true;
//                }
//                else {
//                    }
//                }
//            }
//
//        }
//
//        return false;
//
//    }

    /**
     * Given a sorted array of integers, create a minimal height binary search tree.
     * @param sArr sorted array of integers
     * @return
     */
    public TreeNode createMinimalBST(int[] sArr) {
        if (sArr.length == 0) {
            return null;
        }
        int rootIndex = (sArr.length /2);
        TreeNode newTree = new TreeNode(sArr[rootIndex]);
        int[] leftArr = Arrays.copyOfRange(sArr,0,rootIndex);
        int[] rightArr = Arrays.copyOfRange(sArr,rootIndex+1, sArr.length);
        newTree.setLeft(createMinimalBST(leftArr));
        newTree.setRight(createMinimalBST(rightArr));

        return newTree;
    }

    boolean areTreesIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 != null) {
            boolean valuesEqual = root1.value == root2.value;
            boolean leftEqual = areTreesIdentical(root1.getLeft(), root2.getLeft());
            boolean rightEqual = areTreesIdentical(root1.getRight(), root2.getRight());

            return (valuesEqual && leftEqual && rightEqual);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeProblems prog = new TreeProblems();
        TreeNode root = prog.setupTree(new Integer[]{20, 10, 43, 1, 22, 51});
        System.out.println("Is tree balanced? " +prog.checkBalanced(root));

        int[] sortedArray = {1,4,10,21,30,41};

        TreeNode minimalBST = prog.createMinimalBST(sortedArray);

        TreeNode tree1 = root;
        TreeNode tree2 = prog.setupTree(new Integer[]{20, 10, 43, 1, 22, 51});
        System.out.println("Are trees identical? "+ prog.areTreesIdentical(tree1, tree2));

        tree2 = prog.setupTree(new Integer[]{20, 10, 43, 1, 22, 51, 11});
        System.out.println("Are trees identical? "+ prog.areTreesIdentical(tree1, tree2));

        System.out.println("DONE");
    }
}
