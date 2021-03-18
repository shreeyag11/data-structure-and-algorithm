package com.company;

public class QuickSort {

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end)
            return;

        // Partition
        var boundary = partition(array, start, end);

        // Sort left
        sort(array, start, boundary - 1);

        // Sort right
        sort(array, boundary + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int boundary = start - 1;
        int i = start;
        while(i <= end) {
            if (array[i] <= pivot)
                swap(array, i, ++boundary);
            i++;
        }
        return boundary;
    }

    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
