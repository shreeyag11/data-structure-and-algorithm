package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {7, 3, 1, 4, 6, 2, 3};
        BubbleSort bs = new BubbleSort();
        bs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
