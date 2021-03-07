package com.company;

import java.util.LinkedList;

public class HashTable {

    private LinkedList<Entry>[] hashTable = new LinkedList[5];

    public void put(int key, String value) {
        var entry = getEntry(key);
        if(entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).add(new Entry(key, value));
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = findHash(key);
        var bucket = hashTable[index];
        if (bucket == null)
            hashTable[index] = new LinkedList<>();

        return bucket;
    }

    public String get(int key) {
        var entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if(entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key) {
                    return entry;
                }
            }
        }
        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return hashTable[findHash(key)];
    }

    private int findHash(int key) {
        return key % 5;
    }

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
