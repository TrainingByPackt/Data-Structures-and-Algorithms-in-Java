package com.packt.datastructuresandalg.lesson3.activity.openaddressing.solution;

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
        int s = array.length;
        int hashValue = hashProvider.hashKey(key, s);
        int i = 0;
        while (i < s && array[(hashValue + i) % s] != null)
            i++;
        if (i < s) array[(hashValue + i) % s] = new Pair<>(key, value);
    }

    public Optional<V> get(K key) {
        int s = array.length;
        int hashValue = hashProvider.hashKey(key, s);
        int i = 0;
        while (i < s &&
                array[(hashValue + i) % s] != null &&
                !array[(hashValue + i) % s].getKey().equals(key))
            i++;

        return Optional.ofNullable(array[(hashValue + i) % s])
                .filter(kv -> kv.getKey().equals(key)).map(Pair::getValue);
    }

}
