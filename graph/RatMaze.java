package graph;

public class RatMaze {
    int[][] directions = {{0,1},{1,0}};
    public void solve(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int[][] solution = new int[row][col];
        backtrack(grid,solution,0,0);

    }

    private void backtrack(int[][] grid,int[][] solution,int row,int col){
        if (row == solution.length-1){
            solution[row][col] = 1;
            solution[0][0] = 1;
            for (int[] arr : solution){
                for (int i : arr)
                    System.out.print(i+" ");
                System.out.println();
            }
            return;
        }
        for (int[] arr : directions){
            int newRow = row + arr[0];
            int newCol = col + arr[1];
            if (isSafe(newRow,newCol,grid)){
                solution[newRow][newCol] = 1;
                backtrack(grid, solution,newRow ,newCol);
                solution[newRow][newCol] = 0;
            }

        }
    }

    private boolean isSafe(int row,int col,int[][] grid){
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] != 0;
    }
}
