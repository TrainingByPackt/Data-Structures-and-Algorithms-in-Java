package com.packt.datastructuresandalg.lesson5.activity.badcharacterrule;

import java.util.ArrayList;
import java.util.List;

public class BadCharacterRule {
    public List<Integer> match(String P, String T) {
        int n = T.length();
        int m = P.length();

        int e = 256;
        int left[][] = new int[m][e];
        // Populate left[][] with the correct values

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
}
