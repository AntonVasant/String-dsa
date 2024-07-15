package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FarFromLand {
    public int maxDistance(int[][] grid) {
            int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
            int row = grid.length;
            int col = grid[0].length;
            boolean hasLand = false;
            boolean hasWater = false;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    if (grid[i][j] == 1){
                        queue.offer(new int[]{i,j});
                        hasLand = true;
                    }else hasWater = true;
                }
            }
            if (!hasLand || !hasWater) return -1;
            int count = 0;
            while (!queue.isEmpty()){
                count++;
                int len = queue.size();
                for (int i = 0; i < len; i++){
                    int[] current = queue.poll();
                    for (int[] d : dir){
                        int x = current[0] + d[0];
                        int y = current[1] + d[1];
                        if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 0){
                            grid[x][y] = 1;
                            queue.offer(new int[]{x,y});
                        }
                    }
                }
            }
            return count-1;
        }
    }
