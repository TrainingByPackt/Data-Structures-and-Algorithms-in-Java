package com.packt.datastructuresandalg.lesson1.activity.octaltodecimal;

import junit.framework.TestCase;

public class OctalToDecimalTest extends TestCase {
    public void testZeroOctal() {
        OctalToDecimal octalToDecimal = new OctalToDecimal();
        assertEquals(octalToDecimal.convertToDecimal("0"), 0);
    }

    public void testOneOctal() {
        OctalToDecimal octalToDecimal = new OctalToDecimal();
        assertEquals(octalToDecimal.convertToDecimal("1"), 1);
    }

    public void testFiveOctal() {
        OctalToDecimal octalToDecimal = new OctalToDecimal();
        assertEquals(octalToDecimal.convertToDecimal("5"), 5);
    }

    public void test17Octal() {
        OctalToDecimal octalToDecimal = new OctalToDecimal();
        assertEquals(octalToDecimal.convertToDecimal("17"), 15);
    }

    public void test72625Octal() {
        OctalToDecimal octalToDecimal = new OctalToDecimal();
        assertEquals(octalToDecimal.convertToDecimal("72625"), 30101);
    }

    public void test55142Octal() {
        OctalToDecimal octalToDecimal = new OctalToDecimal();
        assertEquals(octalToDecimal.convertToDecimal("55142"), 23138);
    }
}
