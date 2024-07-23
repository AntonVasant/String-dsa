package graph;

import java.util.Arrays;

public class Dungeon {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // Memoization table
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Start the recursive function
        return minHealth(dungeon, 0, 0, memo);
    }

    private int minHealth(int[][] dungeon, int i, int j, int[][] memo) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // Base case: if we are out of bounds
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        // Base case: if we are at the destination cell
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        // Check if the result is already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Compute the minimum health required to move right and down
        int minHealthRight = minHealth(dungeon, i, j + 1, memo);
        int minHealthDown = minHealth(dungeon, i + 1, j, memo);

        // Compute the minimum health required at the current cell
        int minHealthAtCell = Math.min(minHealthRight, minHealthDown);
        int requiredHealth = Math.max(1, minHealthAtCell - dungeon[i][j]);

        // Memoize the result
        memo[i][j] = requiredHealth;

        return requiredHealth;
    }
}
