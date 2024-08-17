package matrix;

public class SubIslands {
    int row;
    int col;
    boolean isIsland;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        row = grid1.length;
        col = grid1[0].length;
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid2[i][j] == 1){
                    isIsland = true;
                    dfs(grid1,grid2,i,j);
                    if (isIsland) count++;
                }
            }
        }
        return count;
    }


    private void dfs(int[][] grid1,int[][] grid2,int i,int j){
        if (i < 0 || j < 0 || i >= row || j >= col || grid2[i][j] == 0) return;
        if (grid1[i][j] != grid2[i][j])
            isIsland = false;
        grid2[i][j] = 0;
        dfs(grid1, grid2, i+1, j);
        dfs(grid1, grid2, i-1, j);
        dfs(grid1, grid2, i, j+1);
        dfs(grid1, grid2, i, j-1);
    }
}
