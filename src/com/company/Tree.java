package com.company;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if(root == null) {
            root = node;
            return;
        }

        Node current = root;
        while(true) {
            if(value < current.value) {
                if(current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            }
            else {
                if(current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }

    // using iteration
    public boolean find(int value) {
        Node current = root;
        while(current != null) {
            if(value < current.value)
                current = current.left;
            else if(value > current.value)
                current = current.right;
            else
                return true;
        }
        return false;
    }

    // using recursion
    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if(root == null)
            return false;

        if(root.value == value)
            return true;

        return contains(root.left, value) || contains(root.right, value);
    }

    public boolean areSiblings(int first, int second) {
        return areSiblings(root, first, second);
    }

    private boolean areSiblings(Node root, int first, int second) {
        if(root == null)
            return false;

        boolean areSiblings = false;
        if(root.left != null && root.right != null)
            areSiblings = (root.left.value == first && root.right.value == second) ||
                    (root.left.value == second && root.right.value == first);

        return areSiblings ||
                areSiblings(root.left, first, second) ||
                areSiblings(root.right, first, second);
    }

    public void preOrder() {
        System.out.println("Pre-order: ");
        preOrder(root);
        System.out.println();

    }

    private void preOrder(Node root) {
        if(root == null)
            return;
        System.out.print(root.value +" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        System.out.println("Post-order: ");
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value +" ");
    }

    public void inOrder() {
        System.out.println("In-order: ");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.value +" ");
        inOrder(root.right);
    }

    public ArrayList<Integer> printNodesAtDistance(int k) {
        var list = new ArrayList<Integer>();
        printNodesAtDistance(root, k, list);
        return list;
    }

    private void printNodesAtDistance(Node root, int k, List<Integer> list) {
        if (root == null)
            return;

        if(k == 0) {
            list.add(root.value);
            return;
        }

        printNodesAtDistance(root.left, k - 1, list);
        printNodesAtDistance(root.right, k - 1, list);
    }

    public boolean isValidBST() {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if(root.value < min || root.value > max)
            return false;

        return
                isValidBST(root.left, min, root.value - 1) &&
                isValidBST(root.right, root.value + 1, max);
    }

    public boolean isEqual(Tree other) {
        if(other == null)
            return false;

        return isEqual(root, other.root);
    }

    private boolean isEqual(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return true;

        if(root1 != null && root2 != null)
            return root1.value == root2.value &&
                    isEqual(root1.left, root2.left) &&
                     isEqual(root1.right, root2.right);

        return false;
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if(isLeaf(root))
            return root.value;

        var left = min(root.left);
        var right = min(root.right);

        return Math.min(Math.min(left, right), root.value);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if(root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if(root == null)
            return 0;

        return 1 + size(root.left) + size(root.right);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if(root == null)
            return -1;

        if(isLeaf(root))
            return 0;

        return 1 + Math.max(
                height(root.left),
                height(root.right));
    }

    private boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node="+ value;
        }
    }

}
