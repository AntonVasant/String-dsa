package graph;

import java.util.Arrays;

public class CherryPickUp {
        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int[][][] dp = new int[n][n][n];
            for (int[][] layer : dp) {
                for (int[] row : layer) {
                    Arrays.fill(row, Integer.MIN_VALUE);
                }
            }
            return Math.max(0, dfs(grid, dp, n, 0, 0, 0));
        }

        private int dfs(int[][] grid, int[][][] dp, int n, int r1, int c1, int r2) {
            int c2 = r1 + c1 - r2;
            if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                return Integer.MIN_VALUE;
            } else if (r1 == n - 1 && c1 == n - 1) {
                return grid[r1][c1];
            } else if (dp[r1][c1][r2] != Integer.MIN_VALUE) {
                return dp[r1][c1][r2];
            } else {
                int res = grid[r1][c1];
                if (r1 != r2) {
                    res += grid[r2][c2];
                }
                res += Math.max(
                        Math.max(dfs(grid, dp, n, r1 + 1, c1, r2 + 1), dfs(grid, dp, n, r1 + 1, c1, r2)),
                        Math.max(dfs(grid, dp, n, r1, c1 + 1, r2 + 1), dfs(grid, dp, n, r1, c1 + 1, r2))
                );
                dp[r1][c1][r2] = res;
                return res;
            }
        }
    }

