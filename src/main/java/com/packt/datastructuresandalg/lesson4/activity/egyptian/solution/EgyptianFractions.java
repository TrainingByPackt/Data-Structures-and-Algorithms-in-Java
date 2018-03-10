package com.packt.datastructuresandalg.lesson4.activity.egyptian.solution;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator == 0 || denominator == 0)
            return new ArrayList<>();

        if (denominator % numerator == 0) {
            List<Long> l = new ArrayList<>();
            l.add(denominator / numerator);
            return l;
        }

        Long n = denominator / numerator + 1;
        List<Long> r = build(numerator * n - denominator, denominator * n);
        r.add(0, n);
        return r;
    }

    public static void printResult(Long numerator, Long denominator) {
        EgyptianFractions fractions = new EgyptianFractions();
        List<Long> ds = fractions.build(numerator, denominator);
        System.out.print(numerator + "/" + denominator + " =");
        for (int i = 0; i < ds.size(); i++) {
            System.out.print(" 1/" + ds.get(i));
            if (i + 1 < ds.size())
                System.out.print(" +");
            else
                System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        printResult(2l, 3l);
        printResult(6l, 14l);
        printResult(12l, 13l);
    }
}
