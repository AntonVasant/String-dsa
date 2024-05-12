package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDiagonal {
    public int[][] diagonalSort(int[][] mat) {
        int row=mat.length;
        int cols=mat[0].length;
        for(int i=0;i<cols;i++){
            sort(mat,0,i,row,cols);
        }
        for(int i=1;i<row;i++){
            sort(mat,i,0,row,cols);
        }
        return mat;
    }
    private void sort(int[][] mat,int row,int col,int m,int n){
        List<Integer> list = new ArrayList<>();
        int r=row;
        int c=col;
        while(r<m && c<n){
            list.add(mat[r++][c++]);
        }
        Collections.sort(list);
        r=row;
        c=col;
        int index=0;
        while(r<m && c<n){
            mat[r++][c++]=list.get(index++);
        }
    }
}
