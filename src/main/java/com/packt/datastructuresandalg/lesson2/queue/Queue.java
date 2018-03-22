package com.packt.datastructuresandalg.lesson2.queue;

import com.packt.datastructuresandalg.lesson2.linkedlist.DblLinkedListNode;

import java.util.Optional;

public class Queue<V> {
    private DblLinkedListNode<V> head;
    private DblLinkedListNode<V> tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public void enqueue(V item) {
        DblLinkedListNode<V> node = new DblLinkedListNode<>(item, null, tail);
        Optional.ofNullable(tail).ifPresent(n -> n.setNext(node));
        tail = node;
        if(head == null) head = node;
    }

    public Optional<V> dequeue() {
        Optional<DblLinkedListNode<V>> node = Optional.ofNullable(head);
        head = node.flatMap(DblLinkedListNode::getNext).orElse(null);
        Optional.ofNullable(head).ifPresent(n -> n.setPrevious(null));
        if (head == null) tail = null;
        return node.map(DblLinkedListNode::getValue);
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("one");
        q.enqueue("two");
        q.enqueue("three");

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        q.enqueue("one");

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    }
}
