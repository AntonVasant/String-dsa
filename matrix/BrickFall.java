package matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Cell{
    int row;
    int col;
    public Cell(int row,int col){
        this.col = col;
        this.row = row;
    }
}
public class BrickFall {

    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int ans = count(grid);
        System.out.println(ans);
        int[] res = new int[hits.length];
        int index = 0;
        for (int[] arr : hits){
            grid[arr[0]][arr[1]] = 0;
            int count = count(grid);
            res[index++] = ans - count;
            ans -= count;
        }
        return res;
    }

    private int count(int[][] grid){
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1){
                    boolean valid = i == 0 || isStable(grid,i,j);
                    if (valid) ans++;
                }
            }
        }
        return ans;
    }
    private boolean isStable(int[][] grid,int i,int j){
        int row = grid.length;
        int col = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();
        boolean[][] visit = new boolean[row][col];
        visit[i][j] = true;
        queue.offer(new Cell(i,j));
        while (!queue.isEmpty()){
            Cell cur = queue.poll();
            for (int[] dir : directions){
                int x = cur.row + dir[0];
                int y = cur.col + dir[1];
                Cell curr  = new Cell(x,y);
                if (x >= 0 && y >= 0 && x < row && y < col &&  grid[x][y] == 1 && !visit[x][y]){
                    if (x == 0) return true;
                    queue.offer(curr);
                    visit[x][y] = true;
                }
            }
        }
        return false;
    }
}
