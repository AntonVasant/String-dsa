package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExit {
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        boolean[][] visit = new boolean[row][col];
        int steps = 0;
        visit[entrance[0]][entrance[1]] = true;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()){
           int size = queue.size();
           for (int i = 0; i < size; i++){
               int[] cur = queue.poll();
               for (int[] dir : directions){
                   int x = cur[0] + dir[0];
                   int y = cur[1] + dir[1];
                   if (x >= 0 && x < row && y >= 0 && y < col && !visit[x][y] && maze[x][y] != '+'){
                       if (x == 0 || y == 0 || x == row-1 || y == col-1) return steps;
                       visit[x][y] = true;
                       queue.offer(new int[]{x,y});
                   }
               }
           }
            steps++;
        }
        return -1;
    }
}
