package com.company;

import java.util.HashMap;

public class Trie {

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node curr = root;

        for(char ch : word.toCharArray()) {
            if(!curr.hasChild(ch))
                curr.addChild(ch);
            curr = curr.getChild(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if(word == null)
            return false;

        Node curr = root;

        for(char ch : word.toCharArray()) {
            if(!curr.hasChild(ch))
                return false;
            curr = curr.getChild(ch);
        }
        return curr.isEndOfWord;
    }

    public void remove(String word) {
        if(word == null)
            return;

        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if(index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        char ch = word.charAt(index);
        var child = root.getChild(ch);
        if(child == null)
            return;


        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }
    }
}
