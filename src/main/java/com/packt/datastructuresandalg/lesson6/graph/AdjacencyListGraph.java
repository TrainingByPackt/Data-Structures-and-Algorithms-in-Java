package com.packt.datastructuresandalg.lesson6.graph;

import java.util.ArrayList;

public class AdjacencyListGraph {
    ArrayList<Integer>[] adj;

    public AdjacencyListGraph(int nodes) {
        this.adj = new ArrayList[nodes];
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public static void main(String [] args) {
        AdjacencyListGraph g = new AdjacencyListGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 1);
        g.addEdge(4, 3);
        g.addEdge(5, 5);
    }
}
