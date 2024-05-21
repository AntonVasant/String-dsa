package matrix;

public class MatrixAddition {
    public int[][] addition(int[][] matrix,int[][] matrix2){
        int row= matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[row][cols];
        for (int i=0;i<row;i++){
            for (int j=0;j<cols;j++){
                 result[i][j] = matrix[i][j]+matrix2[i][j];
            }
        }
        return result;
    }
}
