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

    public static void main(String[] args) {
        int[] numbers1 = new int[]{66, 24, 75, 22, 12, 87};
        int[] numbers2 = new int[]{32, 41, 98, 66, 39, 24};

        List<Integer> result = new FastInterstectionSol2().intersectionFast(numbers1, numbers2);
        System.out.println(result);
    }

}
