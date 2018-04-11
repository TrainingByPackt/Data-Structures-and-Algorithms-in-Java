package com.packt.datastructuresandalg.lesson3.hashtable;

public interface HashProvider<K> {
    int hashKey(K key, int tableSize);
}
