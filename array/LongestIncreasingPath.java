package array;

public class LongestIncreasingPath {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        if(row == 0 || col == 0) return 0;
        int maxx = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                maxx = Math.max(maxx,dfs(matrix,dp,i,j,row,col));
            }
        }
        return maxx;
    }

    private int dfs(int[][] matrix,int[][] dp, int rows,int cols,int row,int col){
        if(dp[rows][cols] != 0) return dp[rows][cols];
        int max = 1;
        for(int[] dir : dirs){
            int newX = rows + dir[0];
            int newY = cols + dir[1];

            if(newX >= 0 && newX < row && newY >= 0 && newY < col && matrix[newX][newY] > matrix[rows][cols]){
                int length = 1 + dfs(matrix,dp,newX,newY,row,col);
                max = Math.max(max,length);
            }
        }
        dp[rows][cols] = max;
        return max;
    }
}
