package com.packt.datastructuresandalg.lesson4.knapsack;

public class Knapsack {
    public int recursiveAux(int W, int weights[], int values[], int n) {
        if (n == 0 || W == 0)
            return 0;
        if (weights[n - 1] > W)
            return recursiveAux(W, weights, values, n - 1);
        return Math.max(
                values[n - 1] +
                        recursiveAux(W - weights[n - 1], weights, values, n - 1),
                recursiveAux(W, weights, values, n - 1));
    }

    public int recursive(int W, int weights[], int values[]) {
        return recursiveAux(W, weights, values, weights.length);
    }

    public int topDownWithMemoizationAux(int W, int weights[], int values[], int n, int[][] memo) {
        if (n == 0 || W == 0)
            return 0;
        if (memo[n][W] == -1) {
            if (weights[n - 1] > W)
                memo[n][W] = topDownWithMemoizationAux(W, weights, values, n - 1, memo);
            else
                memo[n][W] = Math.max(
                        values[n - 1] + topDownWithMemoizationAux(W - weights[n - 1], weights, values, n - 1, memo),
                        topDownWithMemoizationAux(W, weights, values, n - 1, memo));
        }
        return memo[n][W];
    }

    public int topDownWithMemoization(int W, int weights[], int values[]) {
        int[][] memo = new int[weights.length + 1][W + 1];
        for (int i = 0; i <= weights.length; i++)
            for (int j = 0; j <= W; j++)
                memo[i][j] = -1;
        return topDownWithMemoizationAux(W, weights, values, weights.length, memo);
    }

    public int bottomUp(int weight, int weights[], int values[]) {
        int[][] dp = new int[values.length + 1][weight + 1];
        for (int i = 0; i <= values.length; i++) {
            for (int w = 0; w <= weight; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[values.length][weight];
    }

    public static void main(String[] args) {
        int[] weights = {1, 1, 1};
        int[] values = {10, 20, 30};
        Knapsack k = new Knapsack();
        System.out.println("Maximum value = " + k.recursive(2, weights, values));
        System.out.println("Maximum value = " + k.topDownWithMemoization(2, weights, values));
        System.out.println("Maximum value = " + k.bottomUp(2, weights, values));
    }
}
