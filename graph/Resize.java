package graph;

public class Resize {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
            int row = mat.length;
            int col = mat[0].length;

            if (row * col != r * c) {
                return mat;
            }
            int[] data = new int[row*col];
            int index = 0;
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    data[index++] = mat[i][j];
                }
            }
            index = 0;
            int[][] ans = new int[r][c];
            for (int i = 0; i < r;i++){
                for (int j = 0; j < c; j++){
                    ans[i][j] = data[index++];
                }
            }
            return ans;
    }
}
