package com.packt.datastructuresandalg.lesson1.activity.octaltodecimal.solution;

public class OctalToDecimal {
    public int convertToDecimal(String oct) {
        int result = 0;
        for (int i = 1; i <= oct.length(); i++) {
            int octDigit = Integer.parseInt(oct.charAt(oct.length() - i) + "");
            result += Math.pow(8, i - 1) * octDigit;
        }
        return result;
    }

    public static void main(String args[]) {
        OctalToDecimal octalToDecimal = new OctalToDecimal();
        System.out.println(octalToDecimal.convertToDecimal("17"));
        System.out.println(octalToDecimal.convertToDecimal("72625"));
        System.out.println(octalToDecimal.convertToDecimal("1"));
        System.out.println(octalToDecimal.convertToDecimal("55142"));
    }
}
