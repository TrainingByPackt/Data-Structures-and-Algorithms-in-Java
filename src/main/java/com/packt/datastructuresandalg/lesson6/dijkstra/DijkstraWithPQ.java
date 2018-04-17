package com.packt.datastructuresandalg.lesson6.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraWithPQ {
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
        boolean visited;

        Vertex(int u, int distance) {
            this.distance = distance;
            this.u = u;
            this.visited = false;
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

    public class Node implements Comparable<Node> {
        int u;
        int distance;

        Node(int u, int distance) {
            this.distance = distance;
            this.u = u;
        }

        public int compareTo(Node o) {
            return (int) Math.signum(distance - o.distance);
        }
    }

    List<Edge> adj[];

    public DijkstraWithPQ(int nodes) {
        this.adj = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++)
            this.adj[i] = new ArrayList<>();
    }

    public void addEdge(int u, int v, int weight) {
        adj[u].add(new Edge(v, weight));
    }

    public Path[] dijkstra(int source) {
        Vertex vertices[] = new Vertex[adj.length];
        int parent[] = new int[adj.length];
        for (int i = 0; i < adj.length; i++) {
            Vertex v = new Vertex(i, Integer.MAX_VALUE);
            vertices[i] = v;
            parent[i] = -1;
        }

        vertices[source].distance = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node v = pq.remove();
            if (!vertices[v.u].visited) {
                vertices[v.u].visited = true;
                for (Edge e : adj[v.u]) {
                    Vertex next = vertices[e.v];
                    if (v.distance + e.weight < next.distance) {
                        next.distance = v.distance + e.weight;
                        parent[next.u] = v.u;
                        pq.add(new Node(next.u, next.distance));
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
        DijkstraWithPQ d = new DijkstraWithPQ(5);
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
