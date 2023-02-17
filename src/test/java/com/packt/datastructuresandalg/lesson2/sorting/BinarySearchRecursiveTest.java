package com.packt.datastructuresandalg.lesson2.sorting;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinarySearchRecursiveTest {

    private BinarySearchRecursive sut;
    @Before
    public void setUp() {
        sut = new BinarySearchRecursive();
    }

    @Test
    public void shouldNotFindElementGreaterThanLastInputElement() {
        boolean result = sut.binarySearch(12, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertFalse("12 is not included in the input", result);
    }
    @Test
    public void shouldNotFindElementSmallerThanFirstInputElement() {
        boolean result = sut.binarySearch(0, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertFalse("0 is not included in the input", result);
    }

    @Test
    public void shouldFindElementFromEndOfInput() {
        boolean result = sut.binarySearch(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertTrue("10 is included in the input", result);
    }
    @Test
    public void shouldFindElementFromStartOfInput() {
        boolean result = sut.binarySearch(1, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertTrue("1 is included in the input", result);
    }

    @Test
    public void shouldFindElementInMiddleOfInput() {
        boolean result = sut.binarySearch(7, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertTrue("7 is included in the input", result);
    }

}