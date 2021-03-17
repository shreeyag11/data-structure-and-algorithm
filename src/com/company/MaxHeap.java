package com.company;

public class MaxHeap {
    public static void heapify(int[] arr) {
        for(int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, i);
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;
        var leftChild = 2 * index + 1;
        var rightChild = 2 * index + 2;

        if(leftChild < array.length &&
                array[leftChild] > array[largerIndex]) {
            largerIndex = leftChild;
        }

        if(rightChild < array.length &&
                array[rightChild] > array[largerIndex]) {
            largerIndex = rightChild;
        }

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if(k < 1 || k > array.length)
            throw new IllegalArgumentException();

        var heap = new Heap(array.length);
        for(int val : array) {
            heap.insert(val);
        }
        while(k > 1) {
            heap.remove();
            k--;
        }
        return heap.max();
    }
}
