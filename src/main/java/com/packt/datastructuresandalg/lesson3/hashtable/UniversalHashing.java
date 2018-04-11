package com.packt.datastructuresandalg.lesson3.hashtable;

import java.math.BigInteger;

public class UniversalHashing implements HashProvider<Integer> {

    private final BigInteger i, j;
    private final long p = 47055833459L;

    public UniversalHashing() {
        j = BigInteger.valueOf((long) (Math.random() * p));
        i = BigInteger.valueOf(1 + (long) (Math.random() * (p - 1L)));
    }

    public int hashKey(Integer key, int tableSize) {
        return i.multiply(BigInteger.valueOf(key)).add(j)
                .mod(BigInteger.valueOf(p))
                .mod(BigInteger.valueOf(tableSize))
                .intValue();
    }

    public static void main(String[] args) {
        UniversalHashing universalHashing = new UniversalHashing();
        System.out.println(universalHashing.hashKey(337481990, 1000));
        System.out.println(universalHashing.hashKey(116241990, 1000));
        System.out.println(universalHashing.hashKey(983611990, 1000));
        System.out.println(universalHashing.hashKey(201031990, 1000));

        universalHashing = new UniversalHashing();
        System.out.println(universalHashing.hashKey(337481990, 1000));
        System.out.println(universalHashing.hashKey(116241990, 1000));
        System.out.println(universalHashing.hashKey(983611990, 1000));
        System.out.println(universalHashing.hashKey(201031990, 1000));
    }
}
