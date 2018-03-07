package com.packt.datastructuresandalg.lesson1.circlemath;

public class CircleOperations {
    private double circleCircumference(int radius) {
        return 2.0 * Math.PI * radius;
    }

    public static void main(String args[]) {
        CircleOperations circleOperations = new CircleOperations();
        System.out.println(circleOperations.circleCircumference(79));
    }
}
