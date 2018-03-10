package com.packt.datastructuresandalg.lesson4.points;

import java.util.*;

public class ClosestPairOfPoints {
    static class Point {
        int x;
        int y;

        public Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    static class PointPair {
        Point p;
        Point q;

        public PointPair(Point _p, Point _q) {
            p = _p;
            q = _q;
        }

        public double distance() {
            return Math.sqrt(Math.pow(p.x - q.x, 2) + Math.pow(p.y - q.y, 2));
        }
    }

    PointPair bruteForce(List<Point> points) {
        PointPair best = new PointPair(points.get(0), points.get(1));
        for (int i = 2; i < points.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                PointPair candidate = new PointPair(points.get(i), points.get(j));
                if (candidate.distance() < best.distance())
                    best = candidate;
            }
        }
        return best;
    }

    PointPair bestWithStrip(List<Point> points, PointPair bestSoFar) {
        PointPair best = bestSoFar;
        List<Point> sortedPoints = new ArrayList<>(points);
        Collections.sort(sortedPoints, (o1, o2) -> Integer.signum(o1.y - o2.y));

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size() &&
                    (points.get(j).y - points.get(i).y) < best.distance(); j++) {
                PointPair candidate = new PointPair(points.get(i), points.get(j));
                if (candidate.distance() < best.distance())
                    best = candidate;
            }
        }

        return best;
    }

    PointPair divideAndConquerAux(List<Point> points) {
        int N = points.size();
        if (N <= 3)
            return bruteForce(points);

        int mid = N / 2;
        Point midPoint = points.get(mid);

        PointPair bl = divideAndConquerAux(points.subList(0, mid));
        PointPair br = divideAndConquerAux(points.subList(mid, N));

        PointPair bestSoFar = bl;
        if (br.distance() < bl.distance())
            bestSoFar = br;

        List<Point> strip = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (Math.abs(points.get(i).x - midPoint.x) < bestSoFar.distance())
                strip.add(points.get(i));
        }

        return bestWithStrip(strip, bestSoFar);
    }

    PointPair divideAndConquer(List<Point> points) {
        List<Point> sortedPoints = new ArrayList<>(points);
        Collections.sort(sortedPoints, (o1, o2) -> Integer.signum(o1.x - o2.x));
        return divideAndConquerAux(sortedPoints);
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(2, 3));
        points.add(new Point(12, 30));
        points.add(new Point(40, 50));
        points.add(new Point(5, 1));
        points.add(new Point(12, 10));
        points.add(new Point(3, 4));

        ClosestPairOfPoints closest = new ClosestPairOfPoints();
        PointPair best1 = closest.bruteForce(points);
        PointPair best2 = closest.divideAndConquer(points);

        System.out.println("Distance = " + best1.distance());
        System.out.println("Distance = " + best2.distance());
    }
}
