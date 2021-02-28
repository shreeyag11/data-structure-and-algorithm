package com.company;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void print() {
        Node temp = first;
        while(temp != null) {
            System.out.print(" " + temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    // add first
    public void addFirst(int val) {
        var node = new Node(val);
        if(isEmpty()) {
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    // add last
    public void addLast(int val) {
        var node = new Node(val);
        if(isEmpty()) {
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // delete first
    public void deleteFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        if(first == last) {
            first = last = null;
            size = 0;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    // delete last
    public void deleteLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        if(first == last) {
            last = null;
            first = null;
            size = 0;
            return;
        }
        last = getPrevious(last);
        last.next = null;
        size--;
    }

    // index of
    public int indexOf(int val) {
        int index = 0;
        var curr = first;
        while(curr != null) {
            if(curr.value == val) return index;
            index++;
            curr = curr.next;
        }
        return -1;
    }

    // contains
    public boolean contains(int val) {
        return indexOf(val) != -1;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        var curr = first;
        while(curr != null) {
            if(curr.next == node) return curr;
            curr = curr.next;
        }
        return null;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        int index = 0;
        var curr = first;
        while(curr != null) {
            arr[index++] = curr.value;
            curr = curr.next;
        }
        return arr;
    }

    // Reverse a Linked List
    public void reverse() {
        var prev = first;
        if(isEmpty())
            return;
        while(prev.next != null) {
            var curr = prev.next;
            prev.next = curr.next;
            curr.next = first;
            first = curr;
            last = prev;
        }
        last.next = null;
    }
}
