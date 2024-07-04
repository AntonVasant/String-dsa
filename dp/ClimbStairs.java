package dp;

import java.util.Arrays;

public class ClimbStairs {
    public static int stairs(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    private static int helper(int n,int[] dp){
        if (n == 0) return 1;
        if (dp[n] != -1) return dp[n];
        int nums = 0;
        if (n > 1) nums += helper(n-2,dp);
        nums += helper(n-1,dp);
        return dp[n] = nums;
    }
}
