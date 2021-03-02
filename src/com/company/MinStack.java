package com.company;

import java.util.Stack;

public class MinStack {
    Stack<Integer> st = new Stack();
    private int min = Integer.MAX_VALUE;

    public void push(int value) {
        if(value <= min) {
            st.push(min);
            min = value;
        }
        st.push(value);
    }

    public int pop() {
        int temp = st.pop();
        if(temp == min) {
            min = st.pop();
        }
        return temp;
    }

    public int getMin() {
        return min;
    }

}
