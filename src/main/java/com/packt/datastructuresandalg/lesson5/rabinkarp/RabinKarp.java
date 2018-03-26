package com.packt.datastructuresandalg.lesson5.rabinkarp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RabinKarp {
    public List<Integer> match(String P, String T) {
        // Good enough for ascii characters.
        int d = 256;
        int m = P.length();
        int n = T.length();
        long q = BigInteger.probablePrime(31, new Random()).longValue();

        // Precompute d^(m-1) % q for use when removing leading digit
        long dm = 1;
        for (int i = 1; i <= m - 1; i++)
            dm = (d * dm) % q;

        // Precompute p and t0
        long ph = 0;
        long th = 0;
        for (int i = 0; i < m; i++) {
            ph = (d * ph + P.charAt(i)) % q;
            th = (d * th + T.charAt(i)) % q;
        }

        List<Integer> shifts = new ArrayList<>();
        for (int i = 0; i < n - m + 1; i++) {
            if (ph == th) {
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

            if (i + m < n) {
                th = (th + q - dm * T.charAt(i) % q) % q;
                th = (th * d + T.charAt(i + m)) % q;
            }
        }
        return shifts;
    }

    public static void main(String[] args) {
        RabinKarp rk = new RabinKarp();
        List<Integer> matches = rk.match("rabrabracad", "abacadabrabracabracadabrabrabracad");
        for (Integer i : matches)
            System.out.println(i);
    }
}
