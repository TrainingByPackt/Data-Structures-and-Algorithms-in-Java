package com.packt.datastructuresandalg.lesson4.activity.coinchange.solution;

public class CoinChange {
    public Integer ways(int N, int[] coins) {
        int[][] dp = new int[N + 1][coins.length + 1];
        for (int j = 0; j <= coins.length; j++)
            dp[0][j] = 1;
        for (int j = 1; j <= coins.length; j++) {
            for (int i = 1; i <= N; i++) {
                dp[i][j] = dp[i][j - 1];
                if (i - coins[j - 1] >= 0)
                    dp[i][j] += dp[i - coins[j - 1]][j];
            }
        }
        return dp[N][coins.length];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        CoinChange cc = new CoinChange();
        System.out.println(cc.ways(4, coins));
    }
}
