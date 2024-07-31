package matrix;

import java.util.HashMap;
import java.util.Map;

public class EqualRowCol {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> rowmap = new HashMap<>();
        Map<String,Integer> colmap = new HashMap<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++){
            StringBuilder cur  = new StringBuilder();
            for (int j = 0; j < col; j++){
                cur.append(grid[i][j]);
            }
            rowmap.put(cur.toString(), rowmap.getOrDefault(cur.toString(),0)+1);
        }
        for (int i = 0; i < row; i++){
            StringBuilder cur  = new StringBuilder();
            for (int j = 0; j < col; j++){
                cur.append(grid[j][i]);
            }
            colmap.put(cur.toString(), colmap.getOrDefault(cur.toString(),0)+1);
        }

        int count = 0;
        for (String s : rowmap.keySet()){
            if (colmap.containsKey(s)){
                count += colmap.get(s) * rowmap.get(s);
            }
        }
        return count;
    }
}
