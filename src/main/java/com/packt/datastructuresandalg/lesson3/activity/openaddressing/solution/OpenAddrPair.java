package com.packt.datastructuresandalg.lesson3.activity.openaddressing.solution;

public class OpenAddrPair<K, V> {
    private final K key;
    private final V value;
    private boolean deleted;

    public OpenAddrPair(K key, V value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
