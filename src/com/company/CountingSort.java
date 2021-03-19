package com.company;

public class CountingSort {

    public void sort(int[] array) {
        int max = Integer.MIN_VALUE;

        for(int a : array)
            if (a > max)
                max = a;

        int[] count = new int[max + 1];

        for(int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[k] = i;
                k++;
                count[i]--;
            }
        }
    }
}
