package dp;

import java.util.Arrays;

public class MinimumCoins {
    public int minCoins(int coins[], int M, int V)
    {
        int[][] dp = new int[M+1][V+1];
        for(int i = 0; i <= M; i++)
            Arrays.fill(dp[i],-1);
        int result = helper(coins,M,V,dp,M-1,V);
        return result >= (int) 1e9 ? -1 : result;
    }

    private int helper(int[] coins, int M, int V, int[][] dp, int index, int target) {
        if (index == 0) {
            if (target % coins[0] == 0) {
                return target / coins[0];
            } else {
                return (int) 1e9;
            }
        }

        if (dp[index][target] != -1) return dp[index][target];

        int nonPick = helper(coins, M, V, dp, index - 1, target);

        int pick = (int) 1e9;
        if (target >= coins[index]) {
            pick = 1 + helper(coins, M, V, dp, index, target - coins[index]);
        }
        return dp[index][target] = Math.min(pick, nonPick);
    }
}
