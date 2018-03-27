package com.packt.datastructuresandalg.lesson1.intersection;

import java.util.ArrayList;
import java.util.List;

public class SimpleIntersection {

    public List<Integer> intersection(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>(a.length);
        for (int x : a) {
            for (int y : b) {
                if (x == y) result.add(x);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        SimpleIntersection simpleIntersection = new SimpleIntersection();
        System.out.println(simpleIntersection.intersection(new int[]{4, 7, 5, 2, 3}, new int[]{4, 2, 3, 9, 1}));
    }
}
