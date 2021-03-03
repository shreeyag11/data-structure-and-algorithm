package com.company;

public class PriorityQueue {

    private int[] queue;
    private int count;

    public PriorityQueue(int capacity) {
        queue = new int[capacity];
    }

    public void add(int value) {
        if(isFull())
            throw new IllegalStateException();

        int i = shiftItemsToInsert(value);
        queue[i] = value;
        count++;
    }

    public int remove() {
        if(isEmpty())
            throw new IllegalStateException();
        return queue[--count];
    }

    public boolean isEmpty() {
         return count == 0;
    }

    private int shiftItemsToInsert(int value) {
        int i;
        for(i = count - 1; i >= 0; i--) {
            if (value < queue[i])
                queue[i + 1] = queue[i];
            else
                break;
        }
        return i + 1;
    }

    public boolean isFull() {
        return count == queue.length;
    }
}
