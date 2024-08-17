package matrix;

public class MagicalGrid {
    public int numMagicSquaresInside(int[][] grid) {
            int count = 0;
            int row = grid.length;
            int col = grid[0].length;
            for (int i = 0; i < row - 2; i++){
                for (int j = 0; j < col-2; j++){
                    if (isValid(grid,i,j))
                        count++;
                }
            }
            return count;
    }

    private boolean isValid(int[][] grid,int row,int col){
        boolean[] visit = new boolean[9];
        for (int i = row ;i < row+3; i++){
            for (int j = col ; j < col+3; j++){
                int sum = grid[i][j];
                if (sum < 1 || sum > 9 || visit[sum])
                    return false;
                visit[sum] = true;
            }
        }
        int sum = grid[row][col] + grid[row][col+1]+grid[row][col+2];
        for (int i = 0; i < 3; i++){
            if (grid[row][col+i] + grid[row+1][col+i] + grid[row+2][col+i] != sum ||
                grid[row+i][col] + grid[row+i][col+1] + grid[row+i][col+2] != sum) return false;
        }
        return grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2] == sum &&
                grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col] == sum;
    }
}
