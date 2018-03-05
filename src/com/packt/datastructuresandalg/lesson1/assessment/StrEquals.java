package com.packt.datastructuresandalg.lesson1.assessment;

public class StrEquals {
    public boolean strEqual(String a, String b) {
        for (int i = 0; i < Math.min(b.length(), a.length()); i++)
            if (a.charAt(i) != b.charAt(i)) return false;
        return a.length() == b.length();
    }

    public static void main(String[] args) {
        StrEquals strEquals = new StrEquals();
        System.out.println(strEquals.strEqual("James", "Joao"));
        System.out.println(strEquals.strEqual("Ruth", "Ruth"));
    }
}
