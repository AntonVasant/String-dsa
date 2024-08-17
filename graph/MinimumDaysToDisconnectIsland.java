package graph;

public class MinimumDaysToDisconnectIsland {
        public int minDays(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            if (countIsland(grid) != 1) return 0;
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    if (grid[i][j] == 1){
                        grid[i][j] = 0;
                        if (countIsland(grid) != 1) return 1;
                        grid[i][j] = 1;
                    }
                }
            }
            return 2;
        }


        private int countIsland(int[][] grid){
            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visit = new boolean[row][col];
            int islands = 0;
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    if (grid[i][j] == 1 && !visit[i][j]){
                        islands++;
                        helper(grid,visit,i,j,row,col);
                    }
                }
            }
            return islands;
        }

        private void helper(int[][] grid, boolean[][] visit,int i,int j,int row,int col){
            if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1 || visit[i][j])
                return;
            visit[i][j] = true;
            helper(grid,visit,i+1,j,row,col);
            helper(grid,visit,i-1,j,row,col);
            helper(grid,visit,i,j+1,row,col);
            helper(grid,visit,i,j-1,row,col);
        }
}
