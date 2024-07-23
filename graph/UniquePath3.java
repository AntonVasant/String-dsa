package graph;

public class UniquePath3 {
    int result = 0;
    int spaces = 1;
    public int uniquePathsIII(int[][] grid) {
        int row = grid.length;;
        int col = grid[0].length;
        int startR = 0;
        int startC = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1) {
                    startR = i;
                    startC = j;
                }else if (grid[i][j] == 0) spaces++;
            }
        }
        dfs(grid,startR,startC,row,col,0);
        return result;
    }

    private void dfs(int[][] grid,int i,int j,int row,int col,int count){
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j]== -1)
            return;
        if (grid[i][j] == 2){
            if (count == spaces) result++;
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = -1;
        dfs(grid, i+1, j, row, col,count+1);
        dfs(grid, i-1, j, row, col,count+1);
        dfs(grid, i, j+1, row, col,count+1);
        dfs(grid, i, j-1, row, col,count+1);
        grid[i][j] = temp;
    }
}
