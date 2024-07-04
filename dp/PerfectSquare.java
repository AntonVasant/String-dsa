package dp;

import java.util.Arrays;

public class PerfectSquare {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }

    private int helper(int n,int[] dp){
        if (n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++){
            int remaining = n-i*i;
            min  = Math.min(min,1+helper(remaining,dp));
        }
        return dp[n] = min;
    }
}
