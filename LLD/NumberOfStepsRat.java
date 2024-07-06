package LLD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfStepsRat {

    public static int minimumSteps(int[][] grid,int r,int c){
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int row = grid.length;;
        int col = grid[0].length;
        boolean[][] visit = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                for (int[] arr : directions){
                    int newRow = current[0] + arr[0];
                    int newCol = current[1] + arr[1];
                    if (isSafe(newRow,newCol,row,col) && !visit[newRow][newCol]){
                        if (grid[newRow][newCol] == 4)
                            return ans+1;
                        visit[newRow][newCol] = true;
                        queue.offer(new int[]{newRow,newCol});
                    }
                }
            }
            ans++;
        }
        return ans;
    }

    private static boolean isSafe(int row,int col,int r,int c){
        return row < r && col < c && row >=0 && col >= 0;
    }
}
