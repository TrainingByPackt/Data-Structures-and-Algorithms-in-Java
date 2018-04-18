package com.packt.datastructuresandalg.lesson6.activity.floydwarshall;

import junit.framework.TestCase;

import java.util.Arrays;

public class FloydWarshallTest extends TestCase {
    public void test() {
        FloydWarshall f = new FloydWarshall(5);
        f.addEdge(0, 1, 10);
        f.addEdge(0, 3, 5);
        f.addEdge(1, 3, 2);
        f.addEdge(1, 2, 1);
        f.addEdge(2, 4, 4);
        f.addEdge(3, 1, 3);
        f.addEdge(3, 2, 9);
        f.addEdge(3, 4, 2);
        f.addEdge(4, 2, 6);
        f.run();

        assertTrue(f.path(0, 0).equals(Arrays.asList(0)));
        assertTrue(f.path(0, 1).equals(Arrays.asList(0, 3, 1)));
        assertTrue(f.path(0, 2).equals(Arrays.asList(0, 3, 1, 2)));
        assertTrue(f.path(0, 3).equals(Arrays.asList(0, 3)));
        assertTrue(f.path(0, 4).equals(Arrays.asList(0, 3, 4)));
        assertTrue(f.path(1, 4).equals(Arrays.asList(1, 3, 4)));
    }
}
