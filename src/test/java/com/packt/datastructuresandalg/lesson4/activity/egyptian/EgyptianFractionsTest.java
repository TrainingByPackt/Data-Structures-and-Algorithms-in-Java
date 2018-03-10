package com.packt.datastructuresandalg.lesson4.activity.egyptian;

import junit.framework.TestCase;

import java.util.Arrays;

public class EgyptianFractionsTest extends TestCase {
    EgyptianFractions fractions = new EgyptianFractions();

    public void test1() {
        assertTrue(fractions.build(2l, 3l).equals(Arrays.asList(2l, 6l)));
    }

    public void test2() {
        assertTrue(fractions.build(6l, 14l).equals(Arrays.asList(3l, 11l, 231l)));
    }

    public void test3() {
        assertTrue(fractions.build(12l, 13l).equals(Arrays.asList(2l, 3l, 12l, 156l)));
    }

    public void test4() {
        assertTrue(fractions.build(3l, 4l).equals(Arrays.asList(2l, 4l)));
    }

    public void test5() {
        assertTrue(fractions.build(6l, 7l).equals(Arrays.asList(2l, 3l, 42l)));
    }

    public void test6() {
        assertTrue(fractions.build(5l, 8l).equals(Arrays.asList(2l, 8l)));
    }

    public void test7() {
        assertTrue(fractions.build(123l, 1500l).equals(Arrays.asList(13l, 197l, 1280500l)));
    }

    public void test8() {
        assertTrue(fractions.build(6123l, 7451l).equals(Arrays.asList(2l, 4l, 14l, 2939l, 14955066l, 654986696590548l)));
    }
}
