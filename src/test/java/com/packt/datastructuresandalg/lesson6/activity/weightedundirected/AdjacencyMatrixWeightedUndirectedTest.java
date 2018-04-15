package com.packt.datastructuresandalg.lesson6.activity.weightedundirected;

import junit.framework.TestCase;

public class AdjacencyMatrixWeightedUndirectedTest extends TestCase {
    public void test1() {
        AdjacencyMatrixWeightedUndirected g = new AdjacencyMatrixWeightedUndirected(5);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 4, 5);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(4, 3, 2);

        assertTrue(g.edgeWeight(4, 0) == 5);
        assertTrue(g.edgeWeight(0, 4) == 5);
        assertTrue(g.edgeWeight(0, 1) == 10);
        assertTrue(g.edgeWeight(1, 0) == 10);
        assertTrue(g.edgeWeight(3, 4) == 2);
        assertTrue(g.edgeWeight(1, 3) == 0);
    }
}
