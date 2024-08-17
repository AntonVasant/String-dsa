package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int steps = 1;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visit = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visit[0][0] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] cur = queue.poll();
                for (int[] dir: directions){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x == row-1 && y == col-1) return steps+1;
                    if (x >= 0 &&  y >= 0 && x < row && y < col && grid[x][y] == 0 && !visit[x][y]){
                        queue.offer(new int[]{x,y});
                        visit[x][y] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
