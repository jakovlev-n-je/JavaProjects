package com.vgu.cs.course2.group11.table;

public class Item {

    private final int key;

    private int value;

    public Item(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
