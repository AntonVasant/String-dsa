package matrix;

public class ClosedIsland {
    int row;
    int col;
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int closedIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
               if ( i == 0 || j == 0 || i == row-1 || j == col-1 && grid[i][j] == 0)
                   dfs(grid,i,j);
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 0){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid,int i ,int j) {
        if (i >= row || j >= col || i < 0 || j < 0 || grid[i][j] != 0) return;
        grid[i][j] = 1;
        for (int[] dir : directions)
            dfs(grid, i+dir[0], j+dir[1]);
    }
}
