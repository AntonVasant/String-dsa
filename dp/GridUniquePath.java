package dp;

public class GridUniquePath {
    public static int path(int[][] grid, int row, int col) {
        if (row == 0 && col == 0) return 1;
        if (row < 0 || col < 0) return 0;
        int first = path(grid, row, col - 1);
        int second = path(grid, row - 1, col);
        return first + second;
    }

    public static int memoization(int[][] grid, int[][] dp, int row, int col) {
        if (row == 0 && col == 0) return 1;
        if (row < 0 || col < 0) return 0;
        if (dp[row][col] != -1) return dp[row][col];
        int first = memoization(grid, dp, row, col-1);
        int second = memoization(grid, dp, row-1, col);
        return dp[row][col] = first + second;
    }
    public static int tabulation(int[][] grid,int[][] dp,int row,int col){
        dp[0][0] = 1;
        int first = 0;
        int second = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    if (i > 0)
                        first = dp[i - 1][j];
                    if (j > 0)
                        second = dp[i][j - 1];
                    dp[i][j] = first + second;
                }
            }
        }
        return dp[row-1][col-1];
    }
}
