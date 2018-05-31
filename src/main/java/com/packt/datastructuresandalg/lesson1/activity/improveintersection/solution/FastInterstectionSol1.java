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

    public static void main(String[] args) {
        int[] numbers1 = new int[]{66, 24, 75, 22, 12, 87};
        int[] numbers2 = new int[]{32, 41, 98, 66, 39, 24};

        List<Integer> result = new FastInterstectionSol1().intersectionFast(numbers1, numbers2);
        System.out.println(result);
    }
}
