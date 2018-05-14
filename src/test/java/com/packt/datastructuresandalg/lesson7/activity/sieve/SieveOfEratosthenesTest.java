package com.packt.datastructuresandalg.lesson7.activity.sieve;

import junit.framework.TestCase;

public class SieveOfEratosthenesTest extends TestCase {
    SieveOfEratosthenes sieve = new SieveOfEratosthenes(1000000);

    public void test0() {
        assertFalse(sieve.isPrime(0));
    }

    public void test1() {
        assertFalse(sieve.isPrime(1));
    }

    public void test2() {
        assertTrue(sieve.isPrime(2));
    }

    public void test289049() {
        assertTrue(sieve.isPrime(289049));
    }

    public void test690997() {
        assertTrue(sieve.isPrime(690997));
    }

    public void test690998() {
        assertFalse(sieve.isPrime(690998));
    }

    public void test999983() {
        assertTrue(sieve.isPrime(999983));
    }

    public void test999999() {
        assertFalse(sieve.isPrime(999999));
    }
}
