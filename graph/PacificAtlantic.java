package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for (int i = 0; i < row; i++){
            dfs(heights,pacific,i,0);
            dfs(heights,atlantic,i,col-1);
        }
        for (int i = 0; i < col ; i++){
            dfs(heights,pacific,0,i);
            dfs(heights,atlantic,row-1,i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i < row; i++){
            for (int j = 0; j < col ; j++){
                if (pacific[i][j] && atlantic[i][j] ){
                    result.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] height,boolean[][] ocean,int i,int j){
        int row = height.length;
        int col = height[0].length;
        if (ocean[i][j]) return;
        ocean[i][j] = true;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] d : dir){
            int newX = i + d[0];
            int newY = j + d[1];
            if (newX >= 0 && newX < row && newY >= 0 && newY < col
                    && height[newX][newY] >= height[i][j]){
                dfs(height,ocean,newX,newY);
            }
        }
    }
}
