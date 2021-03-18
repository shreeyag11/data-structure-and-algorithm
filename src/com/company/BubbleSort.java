package com.company;

public class BubbleSort {

    public void sort(int[] array) {
        boolean isSorted;

        for(int i = 0; i < array.length; i++) {
            isSorted = true;
            for(int j = 1; j < array.length - i; j++)
                if(array[j] < array[j - 1]) {
                    isSorted = false;
                    swap(array, j, j - 1);
                }
            if(isSorted)
                return;
        }
    }

    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
