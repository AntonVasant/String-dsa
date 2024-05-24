package matrix;

public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                swap(matrix,i,j);
            }
        }
        for(int i = 0;i<n;i++){
            reverse(matrix[i]);
        }
    }
    private void swap(int[][] matrix,int n,int m){
        int temp = matrix[n][m];
        matrix[n][m] = matrix[m][n];
        matrix[m][n] = temp;
    }
    private void reverse(int[] array){
        int low = 0;
        int high = array.length-1;
        while(low <= high){
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
        }
    }
}
