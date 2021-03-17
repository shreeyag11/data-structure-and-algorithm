package com.company;

import javax.lang.model.type.MirroredTypeException;

public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if(isFull())
            throw new IllegalStateException();

        heap[size++] = value;

        bubbleUp();
    }

    public int remove() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }

        int temp = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = 0;
        size--;

        int index = 0;
        while(index <= size && !isValidParent(index)) {
            swap(index, largerChildIndex(index));
            index = largerChildIndex(index);
        }
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    private void bubbleUp() {
        int index = size - 1;
        while(index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    private void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    private int largerChildIndex(int index) {
        if(!hasLeftChild(index))
            return index;

        if(!hasRightChild(index))
            return left(index);

        return (heap[left(index)] > heap[right(index)]) ? left(index) : right(index);
    }

    private boolean hasLeftChild(int index) {
        return left(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return right(index) <= size;
    }

    private boolean isValidParent(int index) {
        if(!hasLeftChild(index))
            return true;

        if(!hasRightChild(index))
            return heap[index] >= heap[left(index)];

        return heap[index] >= heap[left(index)] &&
                heap[index] >= heap[right(index)];
    }

    public int max() {
        if(isEmpty())
            throw new IllegalStateException();

        return heap[0];
    }

}
