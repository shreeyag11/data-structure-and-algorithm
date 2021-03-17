package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = { 5, 2, 9, 1, 7, 3};
        MaxHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}
