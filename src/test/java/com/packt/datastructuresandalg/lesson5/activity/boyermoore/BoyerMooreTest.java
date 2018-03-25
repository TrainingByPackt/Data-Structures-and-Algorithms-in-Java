package com.packt.datastructuresandalg.lesson5.activity.boyermoore;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class BoyerMooreTest extends TestCase {
    BoyerMoore bm = new BoyerMoore();

    public void test1() {
        assertTrue(bm.match("abc", "abc").equals(Arrays.asList(0)));
    }

    public void test2() {
        assertTrue(bm.match("abd", "abc").equals(new ArrayList<>()));
    }

    public void test3() {
        assertTrue(bm.match("abcde", "abc").equals(new ArrayList<>()));
    }

    public void test4() {
        assertTrue(bm.match("aab", "acaabc").equals(Arrays.asList(2)));
    }

    public void test5() {
        assertTrue(bm.match("aab", "acaabcaab").equals(Arrays.asList(2, 6)));
    }

    public void test6() {
        assertTrue(bm.match("rabrabracad", "abacadabrabracabracadabrabrabracad").equals(Arrays.asList(23)));
    }

}
