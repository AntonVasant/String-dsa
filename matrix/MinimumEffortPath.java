package matrix;

public class MinimumEffortPath {

    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 100000;
        int mid;
        int result = 0;
        while (left < right){
            mid = (left+right)/2;
            if (isReachable(heights,mid)){
                result = mid;
                right = mid-1;
            }
            else left = mid +1;
        }
        return result;
    }

    private boolean isReachable(int[][] grid,int difference){
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visit = new boolean[row][col];
        return helper(grid,0,0,row,col,visit,difference);
    }


    private boolean helper(int[][] grid,int row,int col,int n,int m,boolean[][] visit,int difference){
        if (row == n-1 && col == m-1) return true;
        for (int[] dir : directions){
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && y >= 0 && x < n && y < m && !visit[x][y]){
                if (Math.abs(grid[row][col] - grid[x][y]) <= difference){
                    visit[x][y] = true;
                    if (helper(grid, x, y, n, m, visit, difference)) return true;
                }
            }
        }
        return false;
    }
}
