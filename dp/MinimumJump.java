package dp;

import java.util.Arrays;

public class MinimumJump {
    public static int minJumps(int[] arr, int n) {
        if(n == 1) return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int result = helper(arr, dp, 0, n - 1);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(int[] array, int[] dp, int index, int n) {
        if (index == n) return 0;
        if (index > n || array[index] == 0) return Integer.MAX_VALUE;

        if (dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= array[index]; i++) {
            int jump = helper(array, dp, index + i, n);
            if (jump != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + jump);
            }
        }

        dp[index] = min;
        return dp[index];
    }
}
