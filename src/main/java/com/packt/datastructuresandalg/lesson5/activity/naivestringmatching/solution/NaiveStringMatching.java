package com.packt.datastructuresandalg.lesson5.activity.naivestringmatching.solution;

import java.util.ArrayList;
import java.util.List;

public class NaiveStringMatching {
    public List<Integer> match(String P, String T) {
        int n = T.length();
        int m = P.length();
        List<Integer> shifts = new ArrayList<>();
        for (int i = 0; i < n - m + 1; i++) {
            boolean hasMatch = true;
            for (int j = 0; j < m; j++) {
                if (P.charAt(j) != T.charAt(i + j)) {
                    hasMatch = false;
                    break;
                }
            }
            if (hasMatch)
                shifts.add(i);
        }
        return shifts;
    }

    public static void main(String[] args) {
        NaiveStringMatching nsm = new NaiveStringMatching();
        List<Integer> matches = nsm.match("aab", "acaabc");
        for (Integer i : matches)
            System.out.println(i);
    }
}
