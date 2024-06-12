package dp;

public class MinimumPathGrid {
    public static int minimumPath(int[][] grid,int row,int col){
        if (row == 0 && col == 0) return grid[0][0];
        if (row < 0 || col < 0) return (int)1e9;
        int first  = grid[row][col] + minimumPath(grid, row, col-1);
        int second = grid[row][col] + minimumPath(grid,row-1,col);
        return Math.min(first,second);
    }

    public static int memoization(int[][] grid,int[][] dp,int row,int col){
        if (row == 0 && col == 0) return grid[0][0];
        if (row < 0 || col < 0) return (int)1e9;
        if (dp[row][col] != -1) return dp[row][col];
        int first  = grid[row][col] + memoization(grid,dp, row, col-1);
        int second = grid[row][col] + memoization(grid,dp,row-1,col);
        return dp[row][col] = Math.min(first,second);
    }

    public static int tabulation(int[][] grid, int[][] dp, int row, int col) {
        dp[0][0] = grid[0][0];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row][col];
    }

}
