package com.packt.datastructuresandalg.lesson2.linkedlist;

import java.util.Optional;

public class DblLinkedListNode<V> {
    private V value;
    private DblLinkedListNode<V> next;
    private DblLinkedListNode<V> previous;

    public DblLinkedListNode(V value,
                             DblLinkedListNode<V> next,
                             DblLinkedListNode<V> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Optional<DblLinkedListNode<V>> getNext() {
        return Optional.ofNullable(next);
    }

    public Optional<DblLinkedListNode<V>> getPrevious() {
        return Optional.ofNullable(previous);
    }

    public V getValue() {
        return value;
    }

    public DblLinkedListNode setValue(V value) {
        this.value = value;
        return this;
    }

    public DblLinkedListNode setNext(DblLinkedListNode<V> next) {
        this.next = next;
        return this;
    }


    public DblLinkedListNode setPrevious(DblLinkedListNode<V> previous) {
        this.previous = previous;
        return this;
    }
}
