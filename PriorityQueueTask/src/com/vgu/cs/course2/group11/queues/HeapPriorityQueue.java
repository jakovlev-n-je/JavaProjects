package com.vgu.cs.course2.group11.queues;

import com.vgu.cs.course2.group11.exceptions.QueueException;

public class HeapPriorityQueue implements PriorityQueue {

    private final Element[] items;

    private int size;

    public HeapPriorityQueue(int capacity) {
        items = new Element[capacity];
        size = 0;
    }

    public Element extractMax() throws QueueException {
        if (size == 0) {
            throw new QueueException("Queue is empty");
        }
        Element max = items[0];
        items[0] = items[size - 1];
        items[size - 1] = null;
        size--;
        heapify();
        return max;
    }

    public int getCapacity() {
        return items.length;
    }

    public void increase(int value, int priority) throws QueueException {
        if (size == 0) {
            throw new QueueException("Queue is empty");
        }
        for (int i = 0; i < size; i++) {
            if (items[i].getValue() == value) {
                items[i].raisePriority(priority);
                balance(i, (i - 1) / 2);
                break;
            }
        }
    }

    public void insert(int value, int priority) {
        items[size] = new Element(value, priority);
        balance(size, (size - 1) / 2);
        size++;
    }

    private void balance(int childIndex, int parentIndex) {
        while (childIndex > 0 && items[parentIndex].getPriority() < items[childIndex].getPriority()) {
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    private void heapify() {
        int current = 0;
        int left;
        int right;
        int largest;
        while (current < size) {
            left = 2 * current + 1;
            right = 2 * current + 2;
            largest = current;
            if (left < size && items[left].getPriority() > items[largest].getPriority()) {
                largest = left;
            }
            if (right < size && items[right].getPriority() > items[largest].getPriority()) {
                largest = right;
            }
            if (largest == current) {
                break;
            }
            swap(current, largest);
            current = largest;
        }
    }

    private void swap(int i, int j) {
        Element tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
}
