package dp;

import java.util.HashMap;
import java.util.Map;

public class Dungeon {
    public int calculateMinimumHP(int[][] dungeon) {
        Map<String,Integer> map = new HashMap<>();
        int row = dungeon.length;
        int col = dungeon[0].length;
        return helper(dungeon,map,0,0,row,col);
    }

    private int helper(int[][] grid,Map<String,Integer> map,int i,int j,int row,int col){
        if (i >= row || j >= col) return Integer.MAX_VALUE;
        String key = i+"-"+j;
        if (map.containsKey(key))
            return map.get(key);
        if (i == row-1 && j == col-1) return Math.max(1,1-grid[i][j]);
        int right = helper(grid, map, i, j+1, row, col);
        int down = helper(grid, map, i+1, j, row, col);
        int ans = Math.max(1,Math.min(down,right) - grid[i][j]);
        map.put(key,ans);
        return ans;
    }
}
