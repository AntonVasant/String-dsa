package graph;

public class ImageSmoothner {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1}};
    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                ans[i][j] = helper(img,i,j);
            }
        }
        return ans;
    }

    private int helper(int[][] grid,int i,int j){
        int row = grid.length;
        int col = grid[0].length;
        int count = 1;
        int total = grid[i][j];
        for (int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < row && y >= 0 && y < col){
                count++;
                total+= grid[x][y];
            }
        }
        return total/count;
    }
}
