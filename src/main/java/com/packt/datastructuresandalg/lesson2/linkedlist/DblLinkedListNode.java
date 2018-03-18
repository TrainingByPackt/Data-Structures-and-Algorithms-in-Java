package com.packt.datastructuresandalg.lesson2.linkedlist;

import java.util.Optional;

public class DblLinkedListNode<V> {
    private V value;
    private Optional<DblLinkedListNode<V>> next;
    private Optional<DblLinkedListNode<V>> previous;

    public DblLinkedListNode(V value,
                             Optional<DblLinkedListNode<V>> next,
                             Optional<DblLinkedListNode<V>> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public V getValue() {
        return value;
    }

    public DblLinkedListNode setValue(V value) {
        this.value = value;
        return this;
    }

    public Optional<DblLinkedListNode<V>> getNext() {
        return next;
    }

    public DblLinkedListNode setNext(Optional<DblLinkedListNode<V>> next) {
        this.next = next;
        return this;
    }
}
