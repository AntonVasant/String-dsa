package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceBridge {
    public int shortestBridge(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < row; i++){
            for (int j =0 ; j < col; j++){
                if (grid[i][j] == 1){
                    found = true;
                    dfs(grid,i,j,queue);
                    break;
                }
            }
            if (found)  break;
        }
        int count = 0;
        while (!queue.isEmpty()){
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                for (int[] dir : directions){
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 2) continue;
                    if (grid[x][y] == 1) return count;
                    grid[x][y] = 2;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return -1;
    }

    private void dfs(int[][] board,int i,int j,Queue<int[]> queue){
        if (i < 0 || j< 0 || i >= board.length || j >= board[0].length || board[i][j] == 0 || board[i][j] == 2) return;
        board[i][j] = 2;
        queue.offer(new int[]{i,j});
        dfs(board, i+1, j,queue);
        dfs(board, i-1, j,queue);
        dfs(board, i, j+1,queue);
        dfs(board, i, j-1,queue);
    }
}
