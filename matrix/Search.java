package matrix;

public class Search {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix[0].length;
        int i = 0;
        int j = row-1;
        while(i < matrix.length && j >= 0){
            if(target == matrix[i][j]) return true;
            else if(target < matrix[i][j]) j--;
            else i++;
        }
        return false;
    }
}
