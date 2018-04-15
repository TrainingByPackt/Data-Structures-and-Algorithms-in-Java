package com.packt.datastructuresandalg.lesson6.dfs;

import java.util.ArrayList;

public class Graph {
    ArrayList<Integer> adj[];

    public Graph(int nodes) {
        this.adj = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adj[u].add(v);
    }

    public int[] dfs() {
        boolean[] visited = new boolean[adj.length];
        int[] parent = new int[adj.length];
        for (int i = 0; i < adj.length; i++) {
            visited[i] = false;
            parent[i] = -1;
        }
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i])
                dfsVisit(i, visited, parent);
        }
        return parent;
    }

    public void dfsVisit(int u, boolean[] visited, int[] parent) {
        visited[u] = true;
        for (int i = 0; i < adj[u].size(); i++) {
            int next = adj[u].get(i);
            if (!visited[next]) {
                parent[next] = u;
                dfsVisit(next, visited, parent);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 1);
        g.addEdge(4, 3);
        g.addEdge(5, 5);
        int[] p = g.dfs();
        for (int i = 0; i < 6; i++) {
            System.out.println("Parent of " + i + " in DFS forest is " + p[i]);
        }
    }
}
