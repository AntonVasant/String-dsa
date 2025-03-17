package dp;

import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp =  new int[rows][cols];
        int maxx = 0;
        for(int[] arr : dp)
            Arrays.fill(arr,-1);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    maxx = Math.max(maxx,helper(matrix,dp,i,j));
                }
            }
        }
        return maxx*maxx;
    }

    private int helper(char[][] matrix,int[][] dp,int row,int col){
        if(row < 0 || col < 0 || matrix[row][col] == '0') return 0;

        if(dp[row][col] != -1) return dp[row][col];

        int left = helper(matrix,dp,row,col-1);
        int top = helper(matrix,dp,row-1,col);
        int diag = helper(matrix,dp,row-1,col-1);
        int area = Math.min(Math.min(left,top),diag)+1;
        dp[row][col] = area;
        return area;
    }
}
