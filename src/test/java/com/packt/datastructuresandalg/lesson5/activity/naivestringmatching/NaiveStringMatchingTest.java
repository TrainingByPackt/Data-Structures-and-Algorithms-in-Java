package com.packt.datastructuresandalg.lesson5.activity.naivestringmatching;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class NaiveStringMatchingTest extends TestCase {
    NaiveStringMatching nsm = new NaiveStringMatching();

    public void test1() {
        assertTrue(nsm.match("abc", "abc").equals(Arrays.asList(0)));
    }

    public void test2() {
        assertTrue(nsm.match("abd", "abc").equals(new ArrayList<>()));
    }

    public void test3() {
        assertTrue(nsm.match("abcde", "abc").equals(new ArrayList<>()));
    }

    public void test4() {
        assertTrue(nsm.match("aab", "acaabc").equals(Arrays.asList(2)));
    }

    public void test5() {
        assertTrue(nsm.match("aab", "acaabcaab").equals(Arrays.asList(2, 6)));
    }
}
