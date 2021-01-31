package com.vgu.cs.course2.group11.bloomFilter;

import java.util.List;

public class BloomFilter {

    private static final int DEFAULT_CAPACITY = 50;

    private final boolean[] bits;

    public BloomFilter(int capacity) {
        this.bits = new boolean[capacity];
    }

    public BloomFilter(List<String> items) {
        this(items.size() + DEFAULT_CAPACITY);
        for (String item : items) {
            put(item);
        }
    }

    public boolean mightContain(String item) {
        int hashCode = getFirstHashCode(item);
        boolean isContains = bits[hashCode];
        hashCode = getSecondHashCode(item);
        return isContains && bits[hashCode];
    }

    public void put(String item) {
        int hashCode = getFirstHashCode(item);
        bits[hashCode] = true;
        hashCode = getSecondHashCode(item);
        bits[hashCode] = true;
    }

    private int getFirstHashCode(String item) {
        return getHornerHashCode(item, bits.length, bits.length - 1);
    }

    private int getHornerHashCode(String item, int size, int key) {
        int hashCode = 0;
        for (int i = 0; i < item.length(); i++) {
            hashCode = (key * hashCode + item.charAt(i)) % size;
        }
        return (hashCode * 2 + 1) % size;
    }

    private int getSecondHashCode(String item) {
        return getHornerHashCode(item, bits.length, bits.length + 1);
    }
}
