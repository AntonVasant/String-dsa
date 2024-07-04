package dp;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(triangle,dp,m-1,0,0);
    }
    private int helper(List<List<Integer>> triangle, int[][] dp, int m, int i, int j){
        if(i == m) return triangle.get(m).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int firstMove = triangle.get(i).get(j) + helper(triangle,dp,m,i+1,j);
        int secondMove = triangle.get(i).get(j) + helper(triangle,dp,m,i+1,j+1);
        return dp[i][j] = Math.min(firstMove,secondMove);
    }
    public static int triangle(int[][] triangle,int row,int col,int n){
        if (row == n) return triangle[row][col];
        int first = triangle[row][col] + triangle(triangle,row+1,col+1,n);
        int second = triangle[row][col] + triangle(triangle,row+1,col,n);
        return Math.min(first,second);
    }
    public static int memoization(int[][] triangle,int[][] dp,int row,int col,int n){
        if (row == n) return triangle[row][col];
        if (dp[row][col] != -1) return dp[row][col];
        int first = triangle[row][col] + memoization(triangle,dp,row+1,col+1,n);
        int second = triangle[row][col] + memoization(triangle,dp,row+1,col,n);
        return dp[row][col] = Math.min(first,second);
    }
    public static int tabulation(int[][] triangle,int[][] dp,int row,int col,int n){
        for(int i = 0; i < n; i++)
            dp[n-1][i] = triangle[n-1][i];
        for (int i = n-2;i >=0; i--){
            for (int j = i; j >= 0; j--){
                int first = triangle[i][j] + dp[i+1][j+1];
                int second = triangle[i][j] + dp[i+1][j];
                dp[i][j] = Math.min(second,Math.min(dp[i][j],first));
            }
        }
        return dp[0][0];
    }
}
