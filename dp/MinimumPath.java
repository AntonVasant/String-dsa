package dp;

import java.util.Arrays;

public class MinimumPath {
    public int minimumCostPath(int[][] grid)
    {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return helper(grid,0,0,dp);
    }

    private int helper(int[][] grid,int r,int c,int[][] dp){
        if (r < 0 || c < 0 || r == grid.length || c == grid.length) return Integer.MAX_VALUE;
        if (r == grid.length-1 && c == grid.length-1) return 0;
        if (dp[r][c] != -1) return dp[r][c];
        int up = helper(grid, r-1, c, dp);
        int down = helper(grid, r+1, c, dp);
        int left = helper(grid, r, c-1, dp);
        int right = helper(grid, r, c+1, dp);
        return dp[r][c] = grid[r][c] + Math.min(Math.min(Math.min(up,down),left),right);
    }
}
