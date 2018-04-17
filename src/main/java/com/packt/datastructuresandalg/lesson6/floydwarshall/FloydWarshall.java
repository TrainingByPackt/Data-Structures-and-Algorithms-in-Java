package com.packt.datastructuresandalg.lesson6.floydwarshall;

public class FloydWarshall {
    int[][] adj;

    public FloydWarshall(int nodes) {
        this.adj = new int[nodes][nodes];
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                if (i == j)
                    this.adj[i][j] = 0;
                else
                    this.adj[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void addEdge(int u, int v, int weight) {
        adj[u][v] = Math.min(adj[u][v], weight);
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

    public void run() {
        for (int k = 0; k < adj.length; k++) {
            for (int i = 0; i < adj.length; i++) {
                if (adj[i][k] >= Integer.MAX_VALUE)
                    continue;
                for (int j = 0; j < adj.length; j++) {
                    if (adj[k][j] >= Integer.MAX_VALUE)
                        continue;
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }

    public static void main(String [] args) {
        FloydWarshall g = new FloydWarshall(5);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 4, 4);
        g.addEdge(3, 1, 3);
        g.addEdge(3, 2, 9);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 2, 6);
        g.run();
        System.out.println(g);
    }

}
