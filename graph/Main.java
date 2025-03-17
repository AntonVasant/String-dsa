package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] a) {
        Resize resize = new Resize();
        int[][] mat = {{1, 0}, {2, 0}};
        int row = mat.length;
        int col = mat[0].length;
        int[][] ans =  resize.matrixReshape(mat, 1, 4);
        for (int i = 0; i < 1;i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
