package com.packt.datastructuresandalg.lesson3.hashtable;

public class MultiplicationHashing implements HashProvider<Integer> {
    private double k;

    public MultiplicationHashing(double k) {
        this.k = k;
    }

    public int hashKey(Integer key, int tableSize) {
        return (int) (tableSize * (k * key % 1));
    }

    public static void main(String[] args) {
        MultiplicationHashing multiplicationHashing = new MultiplicationHashing((Math.sqrt(5) - 1) / 2);
        System.out.println(multiplicationHashing.hashKey(337481990, 1000));
        System.out.println(multiplicationHashing.hashKey(116241990, 1000));
        System.out.println(multiplicationHashing.hashKey(983611990, 1000));
        System.out.println(multiplicationHashing.hashKey(201031990, 1000));
    }
}
