package matrix;

public class Transpose {
    public static void matrix(int[][] matrix){
        int n = matrix.length;
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = matrix[j][i];
                System.out.print(matrix[i][j]);
            }
        }

    }
}
