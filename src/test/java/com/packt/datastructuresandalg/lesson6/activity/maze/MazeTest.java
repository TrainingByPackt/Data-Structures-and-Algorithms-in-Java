package com.packt.datastructuresandalg.lesson6.activity.maze;

import junit.framework.TestCase;

public class MazeTest extends TestCase {
    public void test1() {
        Maze m = new Maze(new String[]{
                "####.##",
                "#....##",
                "#.#.#.#",
                "#.#...#",
                "#.###.#",
                "#.....#",
                "#######"
        });
        assertTrue(m.distToExit(1, 1) == 4);
        assertTrue(m.distToExit(5, 1) == 8);
        assertTrue(m.distToExit(2, 5) == 7);
    }
}
