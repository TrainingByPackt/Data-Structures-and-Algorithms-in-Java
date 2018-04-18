package com.packt.datastructuresandalg.lesson6.activity.floydwarshall.solution;

import java.util.ArrayList;
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

    public List<Integer> path(int u, int v) {
        List<Integer> res = new ArrayList<>();
        if (path[u][v] == -1)
            return res;
        int i = v;
        while (u != i) {
            res.add(0, i);
            i = path[u][i];
        }
        res.add(0, u);
        return res;
    }

    public void run() {
        for (int k = 0; k < adj.length; k++) {
            for (int i = 0; i < adj.length; i++) {
                if (adj[i][k] >= Integer.MAX_VALUE)
                    continue;
                for (int j = 0; j < adj.length; j++) {
                    if (adj[k][j] >= Integer.MAX_VALUE)
                        continue;
                    if (adj[i][k] + adj[k][j] < adj[i][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
    }
}
