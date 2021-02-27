package com.company;

import java.util.Arrays;

public class Array {
    private int ptr = 0;
    private int[] arr;

    public Array(int size) {
        arr = new int[size];
    }

    public void insert(int val) {
        if (ptr >= arr.length) {
            arr = Arrays.copyOf(arr, arr.length + 1);
        }
        arr[ptr++] = val;
    }

    public void removeAt(int index) {
        if(index < 0 || index >= ptr) {
            throw new IllegalArgumentException("Position not found");
        }
        for(int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        ptr--;
    }

    public void indexOf(int val) {
        int i;
        for(i = 0; i < arr.length; i++) {
            if(arr[i] == val) {
                System.out.println(i);
                break;
            }
        }
        if(i == arr.length)
            System.out.println(-1);
    }

    public void print() {
        for(int i = 0; i < ptr; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int max() {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public Array intersect(Array m, Array n) {
        Array res = new Array(m.ptr);
        for(int i = 0; i < m.ptr; i++) {
            for(int j = 0; j < n.ptr; j++) {
                if(m.arr[i] == n.arr[j]) {
                    res.insert(m.arr[i]);
                }
            }
        }
        return res;
    }

    public Array reverse(Array arr1) {
        System.out.println(ptr);
        Array rev = new Array(arr1.ptr);
        for (int i = arr1.ptr; i >= 0; i--) {
            rev.insert(arr1.arr[i]);
        }
        return rev;
    }

    public void insertAt(int val, int index) {
        arr = Arrays.copyOf(arr, ptr + 1);
        for(int i = ptr ; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = val;
        ptr++;
    }
}
