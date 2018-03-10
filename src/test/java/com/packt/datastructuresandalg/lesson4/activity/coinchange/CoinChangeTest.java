package com.packt.datastructuresandalg.lesson4.activity.coinchange;

import com.packt.datastructuresandalg.lesson4.activity.coinchange.solution.CoinChange;
import junit.framework.TestCase;

import java.util.Arrays;

public class CoinChangeTest extends TestCase {
    CoinChange change = new CoinChange();

    public void test1() {
        int[] coins = {1, 2, 3};
        assertTrue(change.ways(4, coins) == 4);
    }

    public void test2() {
        int[] coins = {2, 3, 5, 6};
        assertTrue(change.ways(10, coins) == 5);
    }

    public void test3() {
        int[] coins = {1, 5, 10, 25};
        assertTrue(change.ways(63, coins) == 73);
    }
}
