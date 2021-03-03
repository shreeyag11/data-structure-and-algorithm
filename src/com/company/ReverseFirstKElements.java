package com.company;

import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {

    public Queue<Integer> reverse(Queue<Integer> queue, int k) {

        if(k < 0 || queue.size() < k)
            throw new IllegalArgumentException();

        int len = queue.size() - k;

        Stack<Integer> stack = new Stack<>();
        while (k > 0) {
            stack.push(queue.poll());
            k--;
        }

        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        while(len > 0) {
            queue.add(queue.remove());
            len--;
        }

        return queue;
    }
}
