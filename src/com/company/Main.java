package com.company;

public class Main {

    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(3);
        st.push(2);
        System.out.println(st.getMin());
        st.push(1);
        System.out.println(st.getMin());
        st.push(7);
        System.out.println(st.getMin());
        st.push(8);
//        System.out.println(st.pop());
        System.out.println(st.getMin());
    }
}
