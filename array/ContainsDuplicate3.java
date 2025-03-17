package array;

import java.util.*;

public class ContainsDuplicate3 {
    int global = 0;



    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix[0].length;
        int m = matrix.length;
        int ans = -1;
        for (int i = 0; i < m; i++){
            int[] prefix = new int[n];
            for (int j = i; j < m; j++){
                for (int col = 0; col < n; col++){
                    prefix[col] += matrix[j][col];
                }
                ans = Math.max(ans, subArrayHelper(prefix,k));
            }
        }
        return ans;
    }
    private int subArrayHelper(int[] arr, int limit){
        TreeSet<Integer> prefixSums = new TreeSet<>();
        prefixSums.add(0);

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : arr) {
            currentSum += num;
            Integer target = prefixSums.ceiling(currentSum - limit);
            if (target != null) {
                maxSum = Math.max(maxSum, currentSum - target);
            }
            prefixSums.add(currentSum);
        }

        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
    public static void main(String[] args) {
        ContainsDuplicate3 duplicate3 = new ContainsDuplicate3();

    }
}

