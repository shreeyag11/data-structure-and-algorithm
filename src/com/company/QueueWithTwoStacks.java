package com.company;

import java.util.Stack;

public class QueueWithTwoStacks {

    // S1 for adding values and S2 for removing values
    // If S2 is empty move all items of S1 to S2

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int value) {
        s1.push(value);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();
        return s1.pop();
    }

    private void moveStack1ToStack2() {
        if (s2.isEmpty()) {
            while (s1.isEmpty())
                s2.push(s1.pop());
        }
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }


}
