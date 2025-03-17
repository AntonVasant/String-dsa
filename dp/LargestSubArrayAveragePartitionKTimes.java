package dp;

import java.util.Arrays;

public class LargestSubArrayAveragePartitionKTimes {
    public double largestSumOfAverages(int[] arr, int k) {
        int n = arr.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++)
            prefix[i+1] = prefix[i] + arr[i];
        double[][] memo = new double[n][k+1];
        for (double[] a : memo)
            Arrays.fill(a,-1);
        return helper(memo,prefix,0,k,n);
    }

    private double helper(double[][] memo,int[] prefix,int index,int k,int n){
        if (index == prefix.length)
            return k == 0 ? 0 : Double.NEGATIVE_INFINITY;
        if (k == 0) return Double.NEGATIVE_INFINITY;
        double num = Double.NEGATIVE_INFINITY;
        for (int j = index; j < prefix.length; j++){
            double sum = prefix[j+1] - prefix[index];
            double average = sum/(j - index+1);
            num = Math.max(num, average + helper(memo, prefix, j+1, k-1,n));
        }
        memo[index][k] = num;
        return num;
    }
}
