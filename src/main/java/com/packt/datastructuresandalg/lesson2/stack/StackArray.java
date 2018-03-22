package com.packt.datastructuresandalg.lesson2.stack;

import java.util.Optional;

public class StackArray<V> {
    private V[] array;
    private int headPtr = 0;

    public StackArray(int capacity) {
        array = (V[]) new Object[capacity];
    }

    public void push(V item) {
        array[headPtr++] = item;
    }

    public Optional<V> pop() {
        if (headPtr > 0) return Optional.of(array[--headPtr]);
        else return Optional.empty();
    }
}