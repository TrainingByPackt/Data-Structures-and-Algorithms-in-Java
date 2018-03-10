package com.packt.datastructuresandalg.lesson4.lcs;

public class LongestCommonSubsequence {
    public int length(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] c = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    c[i][j] = c[i - 1][j - 1] + 1;
                else
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
            }
        }
        return c[m][n];
    }

    public static void main(String[] args) {
        String s1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String s2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("Length of longest common subsequence = " + lcs.length(s1, s2));
    }
}
