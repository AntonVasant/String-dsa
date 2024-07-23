package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FormLargeIsland {

    private static final int[] DIRS_ROW = {-1, 0, 1, 0};
    private static final int[] DIRS_COL = {0, -1, 0, 1};

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandSizeMap = new HashMap<>();
        int islandIndex = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandIndex);
                    islandSizeMap.put(islandIndex++, size);
                }
            }
        }

        int maxArea = islandSizeMap.getOrDefault(2, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> adjacentIslands = new HashSet<>();
                    int newArea = 1;
                    for (int d = 0; d < 4; d++) {
                        int newRow = i + DIRS_ROW[d];
                        int newCol = j + DIRS_COL[d];
                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] > 1) {
                            int adjacentId = grid[newRow][newCol];
                            if (adjacentIslands.add(adjacentId)) {
                                newArea += islandSizeMap.get(adjacentId);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int r, int c, int index) {
        int n = grid.length;
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = index;
        int size = 1;
        for (int d = 0; d < 4; d++) {
            int newRow = r + DIRS_ROW[d];
            int newCol = c + DIRS_COL[d];
            size += dfs(grid, newRow, newCol, index);
        }
        return size;
    }
}
