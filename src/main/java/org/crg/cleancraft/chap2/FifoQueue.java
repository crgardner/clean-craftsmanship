package org.crg.cleancraft.chap2;

public class FifoQueue {

    private final int[] buffer = new int[3];
    private int size = 0;
    private int front = 0;
    private int back = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int element) {
        if (size >= buffer.length) {
            throw new IllegalStateException("Queue is full");
        }
        buffer[back] = element;

        back = adjust(back);
        size++;
    }

    private int adjust(int position) {
        if (position == buffer.length - 1) {
            position = 0;
        } else {
            position++;
        }
        return position;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Cannot dequeue empty queue");
        }
        size--;
        var dequeuedElement = buffer[front];

        front = adjust(front);

        return dequeuedElement;
    }

    public int size() {
        return size;
    }
}
