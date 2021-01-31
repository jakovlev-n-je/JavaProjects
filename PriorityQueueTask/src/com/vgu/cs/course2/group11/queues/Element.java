package com.vgu.cs.course2.group11.queues;

public class Element {

    private final int value;

    private int priority;

    public Element(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public int getValue() {
        return value;
    }

    public void raisePriority(int priority) {
        this.priority += priority;
    }

    @Override
    public String toString() {
        return String.format("%d ", value);
    }
}
