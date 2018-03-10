package com.packt.datastructuresandalg.lesson4.activity.egyptian;

import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) { return null; }

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
