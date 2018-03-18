package com.packt.datastructuresandalg.lesson1.activity.improveintersection.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FastInterstectionSol2 {

    public List<Integer> intersectionFast(int[] a, int[] b) {
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
}
