package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthPermutation {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++)
            fact[i] = fact[i-1]*i;
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--){
            int index = k/fact[i-1];
            sb.append(list.get(index));
            list.remove(index);
            k%= fact[i-1];
        }
        return sb.toString();
    }



    public static int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[rows-1][cols-1];
        int ans = 0;
        while (low <= high){
            int mid = (low + high)/2;
            if (helper(matrix, mid) >= k){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    private static int helper(int[][] matrix, int mid){
        int rows = matrix.length;
        int cols = matrix[0].length-1;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            while (cols >= 0 &&  matrix[i][cols] > mid)
                cols--;
            count += cols +1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,5,9},
                                    {10,11,13},
                                    {12,14,15}};
        System.out.println(kthSmallest(matrix, 8));
    }
}
