package com.vgu.cs.course2.group11.table;

import com.vgu.cs.course2.group11.exceptions.HashtableException;

public class Hashtable {

    private static final int DEFAULT_CAPACITY = 11;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Item[] table;

    private final float loadFactor;

    private int count;

    public Hashtable() throws HashtableException {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public Hashtable(int initialCapacity, float loadFactor) throws HashtableException {
        if (initialCapacity <= 0) {
            throw new HashtableException("Invalid capacity: " + initialCapacity);
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new HashtableException("Invalid load factor: " + loadFactor);
        }
        this.table = new Item[initialCapacity];
        this.loadFactor = loadFactor;
        this.count = 0;
    }

    public void clear() {
        table = new Item[DEFAULT_CAPACITY];
        count = 0;
    }

    public boolean containsKey(int key) {
        int index = (key & 0x7FFFFFFF) % table.length;
        if (table[index] == null) {
            return false;
        }
        return table[index].getKey() == key || getCorrectItemIndex(index, key) != -1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Integer getValue(int key) {
        int index = (key & 0x7FFFFFFF) % table.length;
        if (table[index] == null) {
            return null;
        }
        if (table[index].getKey() != key) {
            int correctIndex = getCorrectItemIndex(index, key);
            return correctIndex != -1 ? table[correctIndex].getValue() : null;
        }
        return table[index].getValue();
    }

    public void put(int key, int value) {
        int index = (key & 0x7FFFFFFF) % table.length;
        if (table[index] == null) {
            table[index] = new Item(key, value);
            count++;
        } else {
            if (table[index].getKey() == key) {
                table[index].setValue(value);
            } else {
                table[getFreeItemIndex(index)] = new Item(key, value);
                count++;
            }
        }
        if (count == table.length * loadFactor) {
            expand(table.length + DEFAULT_CAPACITY);
        }
    }

    public void remove(int key) {
        int index = (key & 0x7FFFFFFF) % table.length;
        if (table[index] != null) {
            if (table[index].getKey() == key) {
                table[index] = null;
                count--;
            } else {
                int correctIndex = getCorrectItemIndex(index, key);
                if (correctIndex != -1) {
                    table[correctIndex] = null;
                    count--;
                }
            }
        }
    }

    public int size() {
        return count;
    }

    private void expand(int newCapacity) {
        Item[] newTable = new Item[newCapacity];
        if (count + 1 >= 0) {
            System.arraycopy(table, 0, newTable, 0, count + 1);
        }
        table = newTable;
    }

    private int getCorrectItemIndex(int incorrectIndex, int key) {
        for (int correctIndex = incorrectIndex + 1; correctIndex < table.length; correctIndex++) {
            if (table[correctIndex] == null) {
                continue;
            }
            if (key == table[correctIndex].getKey()) {
                return correctIndex;
            }
        }
        return -1;
    }

    private int getFreeItemIndex(int incorrectIndex) {
        int freeIndex = incorrectIndex + 1;
        while (table[freeIndex] != null) {
            freeIndex++;
        }
        return freeIndex;
    }
}
