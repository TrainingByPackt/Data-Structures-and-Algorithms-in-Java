package com.packt.datastructuresandalg.lesson2.linkedlist;

import java.util.Optional;

public class LinkedListNode<V> {
    private V value;
    private LinkedListNode<V> next;

    public LinkedListNode(V value, LinkedListNode<V> next) {
        this.value = value;
        this.next = next;
    }

    public Optional<LinkedListNode<V>> getNext() {
        return Optional.ofNullable(next);
    }

    public V getValue() {
        return value;
    }

    public LinkedListNode setValue(V value) {
        this.value = value;
        return this;
    }

    public LinkedListNode setNext(LinkedListNode<V> next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "value=" + value +
                '}';
    }
}
