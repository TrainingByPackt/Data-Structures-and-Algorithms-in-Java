package com.packt.datastructuresandalg.lesson5.activity.badcharacterrule;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class BadCharacterRuleTest extends TestCase {
    BadCharacterRule bcr = new BadCharacterRule();

    public void test1() {
        assertTrue(bcr.match("abc", "abc").equals(Arrays.asList(0)));
    }

    public void test2() {
        assertTrue(bcr.match("abd", "abc").equals(new ArrayList<>()));
    }

    public void test3() {
        assertTrue(bcr.match("abcde", "abc").equals(new ArrayList<>()));
    }

    public void test4() {
        assertTrue(bcr.match("aab", "acaabc").equals(Arrays.asList(2)));
    }

    public void test5() {
        assertTrue(bcr.match("aab", "acaabcaab").equals(Arrays.asList(2, 6)));
    }

    public void test6() {
        assertTrue(bcr.match("rabrabracad", "abacadabrabracabracadabrabrabracad").equals(Arrays.asList(23)));
    }
}
