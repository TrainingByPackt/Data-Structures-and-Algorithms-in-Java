package com.packt.datastructuresandalg.lesson1.activity.improveintersection.solution;

import com.packt.datastructuresandalg.lesson1.binarysearch.BinarySearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FastIntersection {

    private BinarySearch search = new BinarySearch();

    public List<Integer> intersectionFast1(int[] a, int[] b) {
        List<Integer> result = new LinkedList<>();
        mergeSort(b);
        for (int x : a) {
            if (search.binarySearch(x, b)) result.add(x);
        }
        return result;
    }

    public List<Integer> intersectionFast2(int[] a, int[] b) {
        List<Integer> result = new LinkedList<>();
        mergeSort(a);
        mergeSort(b);
        int ptrA = 0, ptrB = 0;
        while (ptrA < a.length && ptrB < b.length) {
            if (a[ptrA] == b[ptrB]) {
                result.add(a[ptrA]);
                ptrA++;
                ptrB++;
            } else if (a[ptrA] > b[ptrB]) ptrB++;
            else ptrA++;
        }
        return result;
    }

    public void mergeSort(int[] input) {
        Arrays.sort(input);
    }


    public static void main(String[] args) {
        FastIntersection inter = new FastIntersection();
        System.out.println(inter.intersectionFast1(new int[]{4, 7, 5, 2, 3}, new int[]{4, 2, 3, 9, 1}));
        System.out.println(inter.intersectionFast2(new int[]{4, 7, 5, 2, 3}, new int[]{4, 2, 3, 9, 1}));
    }

}
