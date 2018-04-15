package com.packt.datastructuresandalg.lesson6.graph;

public class AdjacencyMatrixGraph {
    int[][] adj;

    public AdjacencyMatrixGraph(int nodes) {
        this.adj = new int[nodes][nodes];
    }

    public void addEdge(int u, int v) {
        this.adj[u][v] = 1;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.adj.length; i++) {
            res += (i + ":");
            for (int j = 0; j < this.adj[i].length; j++)
                res += (" " + adj[i][j]);
            if (i + 1 < adj.length)
                res += "\n";
        }
        return res;
    }

    public static void main(String [] args) {
        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(6);
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
