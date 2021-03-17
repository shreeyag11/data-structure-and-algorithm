package com.company;

public class Main {

    public static void main(String[] args) {
        var heap = new Heap(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);
        heap.remove();
        System.out.println("Done");
    }

}
