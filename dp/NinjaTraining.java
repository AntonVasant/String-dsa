package dp;

import java.util.Arrays;

public class NinjaTraining {
    public static int training(int[][] grid,int n){
        int[][] dp = new int[n+1][4];
        for (int[] arr : dp)
            Arrays.fill(arr,-1);
        return helper(grid,dp,3,n-1);
    }

    private static int helper(int[][] grid,int[][] dp,int move,int index){
        if (index == 0){
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++){
                if (i != move){
                    ans = Math.max(ans,grid[0][i]);
                }
            }
            return ans;
        }
        if (dp[index][move] != -1) return dp[index][move];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++){
            if (i != move){
                ans = Math.max(ans,grid[index][i] + helper(grid, dp, i, index-1));
            }
        }
        dp[index][move] = ans;
        return ans;
    }
}
