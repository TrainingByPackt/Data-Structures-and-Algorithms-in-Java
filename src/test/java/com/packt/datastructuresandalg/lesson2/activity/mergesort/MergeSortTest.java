package com.packt.datastructuresandalg.lesson2.activity.mergesort;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest extends TestCase {
    MergeSort sort = new MergeSort();

    public void testEvenElements() {
        int[] numbers = new int[]{5,3,5,1,6,8,1,9,0,1,3,12};
        sort.mergeSort(numbers);
        assertArrayEquals(new int[]{0,1,1,1,3,3,5,5,6,8,9,12}, numbers);
    }

    public void testOddsElements() {
        int[] numbers = new int[]{5,3,5,1,6,8,1,9,0,1,16,3,12};
        sort.mergeSort(numbers);
        assertArrayEquals(new int[]{0,1,1,1,3,3,5,5,6,8,9,12,16}, numbers);
    }

    public void testAlreadySorted() {
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        sort.mergeSort(numbers);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}, numbers);
    }

    public void testSameNumber() {
        int[] numbers = new int[]{3,3,3,3,3};
        sort.mergeSort(numbers);
        assertArrayEquals(new int[]{3,3,3,3,3}, numbers);
    }

    public void testEmpty() {
        int[] numbers = new int[]{};
        sort.mergeSort(numbers);
        assertArrayEquals(new int[]{}, numbers);
    }

    public void testOneElement() {
        int[] numbers = new int[]{8};
        sort.mergeSort(numbers);
        assertArrayEquals(new int[]{8}, numbers);
    }

}
