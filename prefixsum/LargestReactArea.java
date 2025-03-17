package prefixsum;

import java.util.TreeSet;

public class LargestReactArea {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++){
            int[] prefix = new int[col];
            for (int r = i; r < row; r++){
                for (int c = 0; c < col; c++){
                    prefix[c] += matrix[r][c];
                }

                TreeSet<Integer>  treeSet = new TreeSet<>();
                treeSet.add(0);
                int current = 0;
                for (int n : prefix)
                    current += n;

                Integer required = treeSet.ceiling(current - k);
                if (required != null)
                    maxSoFar = Math.max(maxSoFar,current - required);

                treeSet.add(current);
            }
        }

        return maxSoFar;
    }
}
