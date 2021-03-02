package com.company;

public class Main {

    public static void main(String[] args) {
        TwoStacks st = new TwoStacks();
        st.push1(2);
        st.push1(3);
        st.push1(4);
        st.push2(5);
        st.push2(6);
        st.push2(7);
        st.push2(7);
        st.push2(7);
        st.push2(7);
        st.push1(3);
        System.out.println(st.peek1());
        System.out.println(st.peek2());
        st.print();

        System.out.println(st.pop1());
        System.out.println(st.pop2());
    }
}
