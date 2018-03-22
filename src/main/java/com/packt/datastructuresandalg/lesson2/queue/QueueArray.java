package com.packt.datastructuresandalg.lesson2.queue;

import java.util.Optional;

public class QueueArray<V> {
    private V[] array;
    private int headPtr = 0;
    private int tailPtr = 0;
    private boolean full = false;

    public boolean enqueueSafe(V item) {
        if (!full) {
            array[tailPtr] = item;
            tailPtr = (tailPtr + 1) % array.length;
            this.full = tailPtr == headPtr;
            return true;
        }
        return false;
    }

    public Optional<V> dequeueSafe() {
        if (headPtr != tailPtr || full) {
            Optional<V> item = Optional.of(array[headPtr]);
            headPtr = (headPtr + 1) % array.length;
            this.full = false;
            return item;
        } else return Optional.empty();
    }


    public QueueArray(int capacity) {
        array = (V[]) new Object[capacity];
    }

    public void enqueue(V item) {
        array[tailPtr] = item;
        tailPtr = (tailPtr + 1) % array.length;
    }

    public Optional<V> dequeue() {
        if (headPtr != tailPtr) {
            Optional<V> item = Optional.of(array[headPtr]);
            headPtr = (headPtr + 1) % array.length;
            return item;
        } else return Optional.empty();
    }


    public static void main(String[] args) {
        QueueArray<String> q = new QueueArray<>(5);

        System.out.println(q.enqueueSafe("one"));
        System.out.println(q.enqueueSafe("two"));
        System.out.println(q.enqueueSafe("three"));
        System.out.println(q.enqueueSafe("four"));
        System.out.println(q.enqueueSafe("five"));
        System.out.println(q.enqueueSafe("six"));

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println(q.enqueueSafe("one"));
        System.out.println(q.enqueueSafe("two"));
        System.out.println(q.enqueueSafe("three"));

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println(q.enqueueSafe("one"));
        System.out.println(q.enqueueSafe("two"));
        System.out.println(q.enqueueSafe("three"));

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}