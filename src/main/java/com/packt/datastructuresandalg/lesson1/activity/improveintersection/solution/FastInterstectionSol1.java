package com.packt.datastructuresandalg.lesson1.activity.improveintersection.solution;

import com.packt.datastructuresandalg.lesson1.binarysearch.BinarySearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FastInterstectionSol1 {

    private BinarySearch search = new BinarySearch();

    public List<Integer> intersectionFast(int[] a, int[] b) {
        List<Integer> result = new LinkedList<>();
        mergeSort(b);
        for (int x : a) {
            if (search.binarySearch(x, b)) result.add(x);
        }
        return result;
    }

    private void mergeSort(int[] input) {
        Arrays.sort(input);
    }
}
