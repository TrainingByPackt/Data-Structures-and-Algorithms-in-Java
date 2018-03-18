package com.packt.datastructuresandalg.lesson2.linkedlist;

import java.util.Optional;

public class LinkedListNode<V> {
    private V value;
    private Optional<LinkedListNode<V>> next;

    public LinkedListNode(V value, Optional<LinkedListNode<V>> next) {
        this.value = value;
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public LinkedListNode setValue(V value) {
        this.value = value;
        return this;
    }

    public Optional<LinkedListNode<V>> getNext() {
        return next;
    }

    public LinkedListNode setNext(Optional<LinkedListNode<V>> next) {
        this.next = next;
        return this;
    }
}
