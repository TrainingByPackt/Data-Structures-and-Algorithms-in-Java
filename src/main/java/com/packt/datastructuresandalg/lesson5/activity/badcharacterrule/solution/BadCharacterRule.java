package com.packt.datastructuresandalg.lesson5.activity.badcharacterrule.solution;

import java.util.ArrayList;
import java.util.List;

public class BadCharacterRule {
    public List<Integer> match(String P, String T) {
        int n = T.length();
        int m = P.length();

        int e = 256;
        int left[][] = new int[m][e];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < e; j++)
                left[i][j] = -1;
        for (int i = 0; i < m; i++) {
            if (i != 0)
                for (int j = 0; j < e; j++)
                    left[i][j] = left[i - 1][j];
            left[i][P.charAt(i)] = i;
        }

        List<Integer> shifts = new ArrayList<>();
        int skip;
        for (int i = 0; i < n - m + 1; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (P.charAt(j) != T.charAt(i + j)) {
                    skip = Math.max(1, j - left[j][T.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) {
                shifts.add(i);
                skip = 1;
            }
        }
        return shifts;
    }

    public static void main(String[] args) {
        BadCharacterRule bcr = new BadCharacterRule();
        List<Integer> matches = bcr.match("rabrabracad", "abacadabrabracabracadabrabrabracad");
        for (Integer i : matches)
            System.out.println(i);
    }
}
