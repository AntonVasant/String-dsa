package rescursion;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBridge {
    public static int shortestPath(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++){
            if (found) break;
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1){
                    dfs(grid,visited,i,j,queue);
                    found = true;
                    break;
                }
            }
        }
        int steps = 0;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i < size; i++){
                int[] current = queue.poll();
                for (int[] arr : directions){
                    int newRow = current[0] + arr[0];
                    int newCol = current[1] + arr[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < row && newCol < col &&
                            !visited[newRow][newCol]){
                        if (grid[newRow][newCol] == 1) return steps;
                        visited[newRow][newCol] = true;
                        grid[newRow][newCol] = 1;
                        queue.offer(new int[]{newRow,newCol});
                    }
                }
            }
            steps++;
        }
        return steps;
    }

    private static void dfs(int[][] grid,boolean[][] visited,int row,int col,Queue<int[]> queue){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]) return;

        visited[row][col] = true;
        grid[row][col] = 1;
        queue.offer(new int[]{row,col});
        dfs(grid, visited, row+1, col,queue);
        dfs(grid, visited, row-1, col,queue);
        dfs(grid, visited, row, col+1,queue);
        dfs(grid, visited, row, col-1,queue);

    }
}
