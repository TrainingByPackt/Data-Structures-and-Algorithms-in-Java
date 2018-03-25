package com.packt.datastructuresandalg.lesson5.goodsuffixrule;

import java.util.ArrayList;
import java.util.List;

public class GoodSuffixRule {
    public List<Integer> match(String P, String T) {
        int n = T.length();
        int m = P.length();
        int i = m, j = m + 1;
        int[] f = new int[m + 1];
        int[] s = new int[m + 1];
        f[i] = j;
        while (i > 0) {
            while (j <= m && P.charAt(i - 1) != P.charAt(j - 1)) {
                if (s[j] == 0)
                    s[j] = j - i;
                j = f[j];
            }
            i--; j--;
            f[i] = j;
        }

        j = f[0];
        for (i = 0; i <= m; i++) {
            if (s[i] == 0)
                s[i] = j;
            if (i == j)
                j = f[j];
        }

        List<Integer> shifts = new ArrayList<>();
        int skip;
        for (i = 0; i < n - m + 1; i += skip) {
            boolean hasMatch = true;
            skip = 0;
            for (j = m - 1; j >= 0; j--) {
                if (P.charAt(j) != T.charAt(i + j)) {
                    skip = s[j + 1];
                    hasMatch = false;
                    break;
                }
            }
            if (hasMatch) {
                shifts.add(i);
                skip = s[0];
            }
        }
        return shifts;
    }

    public static void main(String [] args) {
        GoodSuffixRule gsr = new GoodSuffixRule();
        List<Integer> matches = gsr.match("rabrabracad", "abacadabrabracabracadabrabrabracad");
        for (Integer i : matches)
            System.out.println(i);
    }
}
