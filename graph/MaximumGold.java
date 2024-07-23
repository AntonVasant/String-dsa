package graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumGold {
    public int getMaximumGold(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int gold = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] > 0){
                    gold = Math.max(gold,dfs(grid,i,j));
                }
            }
        }
        return gold;
    }

    private int dfs(int[][] grid,int i,int j){
         if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][i] == 0)
             return 0;
         int temp = grid[i][j];
         grid[i][j] = 0;
         int up = temp + dfs(grid, i-1, j);
         int down =temp + dfs(grid, i+1, j);
         int left = temp + dfs(grid, i, j-1);
         int right = temp + dfs(grid, i, j+1);
         grid[i][j] = temp;
         return Math.max(Math.max(Math.max(up,down),left),right);
    }
}
