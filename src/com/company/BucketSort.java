package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public void sort(int[] array, int numberOfBuckets) {
        List<List<Integer>> bucket = createBuckets(array, numberOfBuckets);

        int k = 0;
        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
            for (var item : bucket.get(i))
                array[k++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
        List<List<Integer>> bucket = new ArrayList<>();

        for (int i = 0; i < numberOfBuckets; i++)
            bucket.add(new ArrayList<>());

        for (int item : array)
            bucket.get(item / numberOfBuckets).add(item);

        return bucket;
    }
}
