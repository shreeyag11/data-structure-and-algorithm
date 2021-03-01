package com.company;

public class Main {

    public static void main(String[] args) {
        Stacks st = new Stacks();
        st.push(2);
        st.push(3);
        st.push(4);
        st.pop();
        System.out.println(st.peek());
        st.print();
    }
}
