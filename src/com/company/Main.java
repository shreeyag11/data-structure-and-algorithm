package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(list.size());
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.addLast(12);
        list.addLast(13);
        list.addLast(14);
        list.addLast(15);
        System.out.println(list.size());
        list.print();
//        list.deleteFirst();
//        list.print();
//        list.deleteLast();
//        list.print();
//        list.deleteLast();
//        list.print();
//        System.out.println(list.contains(1));
//        System.out.println(list.indexOf(3));
//
//        int[] arr = list.toArray();
//        System.out.println(Arrays.toString(arr));
//        list.reverse();
//        int[] arr1 = list.toArray();
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(list.getKthNodeFromEnd(6));
//        list.printMiddle();
        System.out.println(list.hasLoop());
    }
}
