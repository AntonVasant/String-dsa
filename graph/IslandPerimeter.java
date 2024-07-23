package graph;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int area = 0;
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if (grid[i][j] == 1){
                    area += 4;

                    if (i > 0 && grid[i-1][j] == 1)
                        area-= 2;
                    if (j > 0 && grid[i][j-1] == 1)
                        area -= 2;
                }
            }
        }
        return area;
    }
}
