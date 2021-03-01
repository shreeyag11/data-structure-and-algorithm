package com.company;

public class Main {

    public static void main(String[] args) {
        Stacks st = new Stacks();
        System.out.println(st.reverse("abcd"));
        System.out.println(st.balancedExpression("(())()"));
    }
}
