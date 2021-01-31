package com.vgu.cs.course2.group11;

import com.vgu.cs.course2.group11.exceptions.QueueException;
import com.vgu.cs.course2.group11.queues.ArrayPriorityQueue;
import com.vgu.cs.course2.group11.queues.HeapPriorityQueue;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws QueueException {
        int capacity = 10;
        Random random = new Random();
        ArrayPriorityQueue arrayPriorityQueue = new ArrayPriorityQueue(capacity);
        HeapPriorityQueue heapPriorityQueue = new HeapPriorityQueue(capacity);
        for (int i = 0; i < capacity; i++) {
            arrayPriorityQueue.insert(random.nextInt(25), random.nextInt(100));
            heapPriorityQueue.insert(random.nextInt(25), random.nextInt(100));
        }
        System.out.println("Очередь с приоритетом (массив): ");
        printQueue(arrayPriorityQueue);
        System.out.println("\nОчередь с приоритетом (куча): ");
        printQueue(heapPriorityQueue);
    }

    public static void printQueue(ArrayPriorityQueue queue) throws QueueException {
        for (int i = 0; i < queue.getCapacity(); i++) {
            System.out.print(queue.extractMax());
        }
    }

    public static void printQueue(HeapPriorityQueue queue) throws QueueException {
        for (int i = 0; i < queue.getCapacity(); i++) {
            System.out.print(queue.extractMax());
        }
    }
}
