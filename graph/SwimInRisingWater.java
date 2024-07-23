package graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        PriorityQueue<int[]>pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        boolean[][] visited = new boolean[row][col];
        pq.offer(new int[]{0,0,grid[0][0]});
        visited[0][0]  = true;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        while (!pq.isEmpty()){
            int cur[] = pq.poll();
            int r = cur[0];
            int c  = cur[1];
            int height = cur[2];
            for (int[] d : dir){
                int x = r + d[0];
                int y = c + d[1];
                if (x == row-1 && y == col-1) return Math.max(height,grid[x][y]);
                if (x >= 0 && y >= 0 && x < row && y < col && !visited[x][y]){
                    visited[x][y] = true;
                    pq.offer(new int[]{x,y,Math.max(height,grid[x][y])});
                }
            }
        }
        return -1;
    }
}
