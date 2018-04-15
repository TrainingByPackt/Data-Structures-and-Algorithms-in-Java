package com.packt.datastructuresandalg.lesson6.activity.maze.solution;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    private int H;
    private int W;
    private int exitI;
    private int exitJ;
    private String[] maze;

    public Maze(String[] maze) {
        this.maze = maze;
        this.H = maze.length;
        this.W = maze[0].length();
        for (int i = 0; i < W; i++) {
            if (maze[0].charAt(i) == '.') {
                this.exitI = 0;
                this.exitJ = i;
                return;
            }
            if (maze[H - 1].charAt(i) == '.') {
                this.exitI = H - 1;
                this.exitJ = i;
                return;
            }
        }
        for (int i = 1; i < H - 1; i++) {
            if (maze[i].charAt(0) == '.') {
                this.exitI = i;
                this.exitJ = 0;
                return;
            }
            if (maze[i].charAt(W - 1) == '.') {
                this.exitI = i;
                this.exitJ = W - 1;
                return;
            }
        }
    }

    private class Pos {
        int i;
        int j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int distToExit(int i, int j) {
        int[][] dist = new int[H][W];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                dist[h][w] = -1;
            }
        }

        Queue<Pos> q = new LinkedList<>();
        dist[i][j] = 0;
        q.add(new Pos(i, j));
        while (!q.isEmpty()) {
            Pos current = q.remove();
            if (current.i == this.exitI && current.j == this.exitJ)
                return dist[current.i][current.j];
            for (int d = 0; d < directions.length; d++) {
                int ni = current.i + directions[d][0];
                int nj = current.j + directions[d][1];
                if (this.maze[ni].charAt(nj) == '.' && dist[ni][nj] == -1) {
                    dist[ni][nj] = dist[current.i][current.j] + 1;
                    q.add(new Pos(ni, nj));
                }
            }
        }
        return -1;
    }
}
