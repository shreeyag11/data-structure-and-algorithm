package com.company;

public class Main {

    public static void main(String[] args) {
        Array arr = new Array(3);
        arr.insert(10);
        arr.insert(20);
        arr.insert(30);
        arr.insert(50);
        arr.print();
        arr.insert(20);
        arr.print();
//        arr.removeAt(4);
        arr.print();
//        arr.removeAt(6);
//        arr.indexOf(20);
        arr.insertAt(100, 2);
        arr.print();
        arr.reverse(arr);
    }
}
