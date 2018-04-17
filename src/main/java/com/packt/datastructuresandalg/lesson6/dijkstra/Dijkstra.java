package com.packt.datastructuresandalg.lesson6.dijkstra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dijkstra {
    private class Edge {
        int v;
        int weight;

        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    private class Vertex {
        int u;
        int distance;

        Vertex(int u, int distance) {
            this.distance = distance;
            this.u = u;
        }
    }

    public class Path {
        int from;
        int to;
        int distance;
        List<Integer> path;

        Path(int from, int to, int distance, List<Integer> path) {
            this.from = from;
            this.to = to;
            this.distance = distance;
            this.path = path;
        }
    }

    List<Edge> adj[];

    public Dijkstra(int nodes) {
        this.adj = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++)
            this.adj[i] = new ArrayList<>();
    }

    public void addEdge(int u, int v, int weight) {
        adj[u].add(new Edge(v, weight));
    }

    private Vertex getBestEstimate(Set<Vertex> vertices) {
        Vertex best = null;
        for (Vertex v : vertices) {
            if (best == null || v.distance < best.distance)
                best = v;
        }
        return best;
    }

    public Path[] dijkstra(int source) {
        Set<Vertex> notVisited = new HashSet<>();
        Set<Vertex> visited = new HashSet<>();
        Vertex vertices[] = new Vertex[adj.length];
        int parent[] = new int[adj.length];
        for (int i = 0; i < adj.length; i++) {
            Vertex v = new Vertex(i, Integer.MAX_VALUE);
            vertices[i] = v;
            parent[i] = -1;
            notVisited.add(v);
        }

        vertices[source].distance = 0;
        while (!notVisited.isEmpty()) {
            Vertex v = getBestEstimate(notVisited);
            notVisited.remove(v);
            visited.add(v);
            for (Edge e : adj[v.u]) {
                if (!visited.contains(e.v)) {
                    Vertex next = vertices[e.v];
                    if (v.distance + e.weight < next.distance) {
                        next.distance = v.distance + e.weight;
                        parent[next.u] = v.u;
                    }
                }
            }
        }

        Path[] paths = new Path[adj.length];

        for (int i = 0; i < adj.length; i++) {
            List<Integer> path = new ArrayList<>();
            Path p = new Path(source, i, vertices[i].distance, path);
            int j = i;
            while (parent[j] != -1) {
                path.add(0, j);
                j = parent[j];
            }
            paths[i] = p;
        }

        return paths;
    }

    public static void main(String [] args) {
        Dijkstra d = new Dijkstra(5);
        d.addEdge(0, 1, 10);
        d.addEdge(0, 3, 5);
        d.addEdge(1, 3, 2);
        d.addEdge(1, 2, 1);
        d.addEdge(2, 4, 4);
        d.addEdge(3, 1, 3);
        d.addEdge(3, 2, 9);
        d.addEdge(3, 4, 2);
        d.addEdge(4, 2, 6);

        Path[] paths = d.dijkstra(0);
        for (int i = 0; i < paths.length; i++) {
            Path p = paths[i];
            System.out.print("Path from " + p.from + " to " + p.to + " (" + p.distance + ")");
            for (int j = 0; j < p.path.size(); j++) {
                System.out.print(" " + p.path.get(j));
            }
            System.out.println();
        }
    }
}
