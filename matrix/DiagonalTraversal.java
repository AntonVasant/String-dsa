package matrix;

public class DiagonalTraversal {
    public int[] findDiagonalOrder(int[][] mat) {
        int rowCount = mat.length;
        int colCount = mat[0].length;
        int[] ans = new int[rowCount*colCount];
        int index = 0;
        for(int i = 0; i <= rowCount+colCount -2; i++){
            if (i % 2 == 0){
                int row = Math.min(rowCount-1,i);
                int col = i - row;
                while (row >= 0 && col < colCount){
                    ans[index++] = mat[row][col];
                    row--;
                    col++;
                }
            }
            else{
                int col = Math.min(i,colCount-1);
                int row = i - col;
                while (col >= 0 && row < rowCount){
                    ans[index++] = mat[row][col];
                    row++;
                    col--;
                }

            }
        }
        return ans;
    }
}
