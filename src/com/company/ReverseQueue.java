package com.company;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack();
        while(!queue.isEmpty())
            stack.add(queue.remove());

        while(!stack.isEmpty())
            queue.add(stack.pop());

        System.out.println(queue);
    }
}
