package greedy;

public class CitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                int[] cur = helper(grid,row,col,i,j);
                count += grid[i][j] == Math.max(cur[0],cur[1]) ? 0 : Math.min(cur[0],cur[1]);
            }
        }
        return count;
    }


    private int[] helper(int[][] grid,int row,int col,int x,int y){
        int[] ans = new int[2];
        int limit = Math.max(row,col);
        for (int i = 0; i < limit; i++){
            if (row <= i)
                ans[0] = Math.max(ans[0],grid[i][y]);
            if (col <= i)
                ans[1] = Math.max(ans[1],grid[x][i]);
        }
        return ans;
    }
}
