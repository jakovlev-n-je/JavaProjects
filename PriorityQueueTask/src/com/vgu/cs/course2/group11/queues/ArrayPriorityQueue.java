package com.vgu.cs.course2.group11.queues;

import com.vgu.cs.course2.group11.exceptions.QueueException;

public class ArrayPriorityQueue implements PriorityQueue {

    private final Element[] items;

    private int size;

    public ArrayPriorityQueue(int capacity) {
        items = new Element[capacity];
        size = 0;
    }

    public Element extractMax() throws QueueException {
        if (size == 0) {
            throw new QueueException("Queue is empty");
        }
        Element max = items[size - 1];
        items[size - 1] = null;
        size--;
        return max;
    }

    public int getCapacity() {
        return items.length;
    }

    public void increase(int value, int priority) throws QueueException {
        if (size == 0) {
            throw new QueueException("Queue is empty");
        }
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getValue() == value) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            items[index].raisePriority(priority);
        } else {
            throw new QueueException("Incorrect value");
        }
        sort();
    }

    public void insert(int value, int priority) {
        items[size] = new Element(value, priority);
        size++;
        sort();
    }

    private void sort() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < size; i++) {
                if (items[i].getPriority() < items[i - 1].getPriority()) {
                    swap(i, i - 1);
                    isSorted = false;
                }
            }
        }
    }

    private void swap(int i, int j) {
        Element tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
}
