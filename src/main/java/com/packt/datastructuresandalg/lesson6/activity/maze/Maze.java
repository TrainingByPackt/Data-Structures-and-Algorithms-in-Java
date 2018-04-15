package com.packt.datastructuresandalg.lesson6.activity.maze;

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

    public int distToExit(int i, int j) {
        return -1;
    }
}
