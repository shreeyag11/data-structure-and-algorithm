package com.company;

public class Main {

    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");
        System.out.println(trie.autoComplete(null));
        System.out.println(trie.contains("car"));
        System.out.println(trie.contains(" "));
    }

}
