package com.packt.datastructuresandalg.lesson7.activity.sieve.solution;

import java.util.Arrays;

public class SieveOfEratosthenes {
    private boolean[] prime;

    public SieveOfEratosthenes(int maxValue) {
        prime = new boolean[maxValue + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        int l = (int) Math.sqrt(maxValue);
        for (int i = 2; i <= l; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= maxValue; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public boolean isPrime(int value) {
        return prime[value];
    }
}
