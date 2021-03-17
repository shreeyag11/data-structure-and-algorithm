package com.company;

public class AVLTree {

    private AVLNode root;

    private class AVLNode {
        private int value;
        private AVLNode left;
        private AVLNode right;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if(root == null)
            return new AVLNode(value);

        if(value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }

    public void remove() {

    }

    @Override
    public String toString() {
        return "Value = "+ root.value;
    }

}
