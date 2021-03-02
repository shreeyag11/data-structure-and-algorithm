package com.company;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Stacks {

    private final List<Character> leftBrackets = Arrays.asList('(', '[', '{', '<');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '}', '>');
    private int[] stack;
    private int ptr;

    

    public Stacks() {
        stack = new int[10];
        ptr = -1;
    }

    public void push(int value) {
        if(ptr == stack.length)
            throw new StackOverflowError();
        stack[++ptr] = value;
    }

    public int pop() {
        if(isEmpty())
            throw new EmptyStackException();
        return stack[ptr--];
    }

    public int peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return stack[ptr];
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public String reverse(String input) {
        if(input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack();
        StringBuffer reversed = new StringBuffer();

        for(char ch : input.toCharArray())
            stack.push(ch);

        while(!stack.isEmpty())
            reversed.append(stack.pop());

        return reversed.toString();
    }

    public boolean balancedExpression(String input) {
        Stack<Character> stack = new Stack<>();

        for(char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if(stack.isEmpty()) return false;

                var top = stack.pop();
                if(bracketsMatch(top, ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    public void print() {
        var content = Arrays.copyOfRange(stack, 0, ptr + 1);
        System.out.println(Arrays.toString(content));
    }
}
