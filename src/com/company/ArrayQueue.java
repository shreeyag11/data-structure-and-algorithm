package com.company;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
    }

    public void enqueue(int value) {
        if (isFull())
            throw new IllegalStateException();
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        count++;
    }

    public int dequeue() {
        int temp = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;
        return temp;
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return queue[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return count == queue.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
