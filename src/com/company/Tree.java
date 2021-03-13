package com.company;

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
