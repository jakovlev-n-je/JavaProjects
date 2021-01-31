package com.vgu.cs.course2.group11.queues;

import com.vgu.cs.course2.group11.exceptions.QueueException;

public interface PriorityQueue {

    Element extractMax() throws QueueException;

    void increase(int value, int priority) throws QueueException;

    void insert(int value, int priority);
}
