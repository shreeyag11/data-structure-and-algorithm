package com.company;

import java.util.Arrays;
import java.util.EmptyStackException;

public class TwoStacks {

    private int[] stack = new int[10];
    private int ptr1 = -2; // Even
    private int ptr2 = -1; // Odd

    public void push1(int value) {
        if(ptr1 > stack.length)
            throw new StackOverflowError();
        ptr1 += 2;
        stack[ptr1] = value;
    }
    public void push2(int value) {
        if(ptr2 > stack.length)
            throw new StackOverflowError();
        ptr2 += 2;
        stack[ptr2] = value;
    }

    public int peek1() {
        if(ptr1 == -2)
            throw new EmptyStackException();
        return stack[ptr1];
    }

    public int peek2() {
        if(ptr2 == -1)
            throw new EmptyStackException();
        return stack[ptr2];
    }

    public int pop1() {
        if(ptr1 == 0)
            throw new EmptyStackException();
        int temp = stack[ptr1];
        ptr1 -= 2;
        return temp;
    }

    public int pop2() {
        if(ptr2 == 0)
            throw new EmptyStackException();
        int temp = stack[ptr2];
        ptr2 -= 2;
        return temp;
    }

    public void print() {
        var content = Arrays.copyOfRange(stack, 0, Math.max(ptr1, ptr2) + 1);
        System.out.println(Arrays.toString(content) + " ptr1: "+ptr1 +" ptr2: "+ptr2);
    }
}
