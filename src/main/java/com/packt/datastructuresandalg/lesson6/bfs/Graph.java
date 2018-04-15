package com.packt.datastructuresandalg.lesson6.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public int[] bfs(int start) {
        int[] parent = new int[this.adj.length];
        boolean[] visited = new boolean[this.adj.length];

        for (int i = 0; i < this.adj.length; i++) {
            parent[i] = -1;
            visited[i] = false;
        }

        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int current = q.remove();
            for (int i = 0; i < this.adj[current].size(); i++) {
                int next = this.adj[current].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    q.add(next);
                }
            }
        }
        return parent;
    }

    public static void main(String [] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 1);
        g.addEdge(4, 3);
        g.addEdge(5, 5);
        int[] parent = g.bfs(2);
        for (int i = 0; i < 6; i++) {
            System.out.print("Path from 2 to " + i + ":");
            if (parent[i] == -1 && i != 2)
                System.out.println(" None");
            else {
                String path = "";
                int j = i;
                while (j != -1) {
                    path = (" " + j) + path;
                    j = parent[j];
                }
                System.out.println(path);
            }
        }
    }
}
