package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetZero {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        for(List<Integer> li : list)
            helper(matrix,li.get(0),li.get(1),n,m);
    }

    private void helper(int[][] matrix,int row,int col,int n,int m){
        for(int i = 0; i < n; i++)
            matrix[i][col] = 0;
        for(int i = 0; i < m; i++)
            matrix[row][i] = 0;
    }
}
