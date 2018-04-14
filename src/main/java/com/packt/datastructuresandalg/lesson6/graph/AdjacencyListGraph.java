package com.packt.datastructuresandalg.lesson6.graph;

import java.util.ArrayList;

public class AdjacencyListGraph {
    ArrayList<Integer>[] adj;

    public AdjacencyListGraph(int nodes) {
        this.adj = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++)
            this.adj[i] = new ArrayList<>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < adj.length; i++) {
            res += (i + ":");
            for (int j = 0; j < adj[i].size(); j++)
                res += (" " + adj[i].get(j));
            if (i + 1 < adj.length)
                res += "\n";
        }
        return res;
    }

    public static void main(String [] args) {
        AdjacencyListGraph g = new AdjacencyListGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 1);
        g.addEdge(4, 3);
        g.addEdge(5, 5);
        System.out.println(g);
    }
}
