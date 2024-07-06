package LLD;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> pq = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int goodMangoes = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    pq.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1)
                    goodMangoes++;
            }
        }
        int minutes = 0;
        if(goodMangoes == 0) return 0;
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i = 0; i < size; i++){
                int[] current = pq.poll();
                for(int[] arr : dir){
                    int newX = current[0] + arr[0];
                    int newY = current[1] + arr[1];

                    if(isSafe(newX,newY,row,col)){
                        if(grid[newX][newY] == 1){
                            grid[newX][newY] = 2;
                            pq.offer(new int[]{newX,newY});
                            goodMangoes--;
                        }
                    }
                }
            }
            minutes++;
            if(goodMangoes == 0) return minutes;
        }

        return -1;
    }

    private boolean isSafe(int row,int col,int r,int c){
        return row >= 0 && col >= 0 && row < r && col < c;
    }
}
