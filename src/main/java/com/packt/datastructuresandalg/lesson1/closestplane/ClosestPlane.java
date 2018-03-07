package com.packt.datastructuresandalg.lesson1.closestplane;

import com.packt.datastructuresandalg.lesson1.binarytodecimal.BinaryToDecimal;

import java.util.ArrayList;
import java.util.List;

public class ClosestPlane {
    public double minimumDistance(List<Point> allPlanes) {
        double minDistance = Double.MAX_VALUE;
        for (Point p1 : allPlanes) {
            for (Point p2 : allPlanes) {
                double d = p1.distanceTo(p2);
                if (d != 0 && d < minDistance) minDistance = d;
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        ClosestPlane closestPlane = new ClosestPlane();

        System.out.println("BinaryToDecimal 11011 -> " + binaryToDecimal.convertToDecimal("10110"));
        System.out.println("BinaryToDecimal 11011 -> " + binaryToDecimal.convertToDecimalAlt("10110"));

        ArrayList<Point> allPlanes = new ArrayList<Point>();
        allPlanes.add(new Point(5, 5));
        allPlanes.add(new Point(15, 66));
        allPlanes.add(new Point(105, 42));
        allPlanes.add(new Point(7, 6));

        System.out.println("Minimum distance: " + closestPlane.minimumDistance(allPlanes));

        for (int j = 0; j < 7; j++) {
            ArrayList<Point> allPlanes2 = new ArrayList<Point>();
            for (int i = 0; i < (500 * Math.pow(2, j)); i++) {
                allPlanes2.add(new Point((int) (Math.random() * 100000.0), (int) (Math.random() * 100000.0)));
            }
            long start = System.currentTimeMillis();
            double minD = closestPlane.minimumDistance(allPlanes2);
            long end = System.currentTimeMillis();
            System.out.println("Minimum distance: " + minD + " for " + allPlanes2.size() + " in: " + (end - start));
        }
    }

}
