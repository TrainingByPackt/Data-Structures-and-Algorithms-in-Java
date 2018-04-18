package com.packt.datastructuresandalg.lesson6.activity.floydwarshall;

import java.util.List;

public class FloydWarshall {
    int[][] adj;
    int[][] path;

    public FloydWarshall(int nodes) {
        this.adj = new int[nodes][nodes];
        this.path = new int[nodes][nodes];
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                if (i == j) {
                    this.adj[i][j] = 0;
                    this.path[i][j] = i;
                } else {
                    this.adj[i][j] = Integer.MAX_VALUE;
                    this.path[i][j] = -1;
                }
            }
        }
    }

    public void addEdge(int u, int v, int weight) {
        if (weight < adj[u][v]) {
            adj[u][v] = weight;
            path[u][v] = u;
        }
    }

    public List<Integer> path(int u, int v) { return null; }

    public void run() { }
}
