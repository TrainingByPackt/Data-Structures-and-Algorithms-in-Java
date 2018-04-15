package com.packt.datastructuresandalg.lesson6.activity.weightedundirected;

public class AdjacencyMatrixWeightedUndirected {
    int[][] adj;

    public AdjacencyMatrixWeightedUndirected(int nodes) {
        this.adj = new int[nodes][nodes];
    }

    public void addEdge(int u, int v, int weight) { }

    public int edgeWeight(int u, int v) { return 0; }
}
