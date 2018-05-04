package com.packt.datastructuresandalg.lesson3.activity.openaddressing;

import com.packt.datastructuresandalg.lesson3.hashtable.HashProvider;
import com.packt.datastructuresandalg.lesson3.hashtable.HashTable;
import com.packt.datastructuresandalg.lesson3.hashtable.Pair;

import java.util.Optional;

public class OpenAddrHashTable<K, V> implements HashTable<K, V> {
    private final HashProvider<K> hashProvider;
    private Pair<K, V>[] array;

    public OpenAddrHashTable(int capacity, HashProvider<K> hashProvider) {
        array = new Pair[capacity];
        this.hashProvider = hashProvider;
    }

    public void put(K key, V value) {
    }

    public void remove(K key) {
    }

    public Optional<V> get(K key) {
        return Optional.empty();
    }
}
