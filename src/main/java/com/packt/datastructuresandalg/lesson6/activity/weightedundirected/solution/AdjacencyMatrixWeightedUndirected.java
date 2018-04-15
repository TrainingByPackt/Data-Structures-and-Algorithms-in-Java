package com.packt.datastructuresandalg.lesson6.activity.weightedundirected.solution;

public class AdjacencyMatrixWeightedUndirected {
    int[][] adj;

    public AdjacencyMatrixWeightedUndirected(int nodes) {
        this.adj = new int[nodes][nodes];
    }

    public void addEdge(int u, int v, int weight) {
        this.adj[u][v] = this.adj[v][u] = weight;
    }

    public int edgeWeight(int u, int v) {
        return this.adj[u][v];
    }
}
