package dp;

import java.util.Arrays;

public class Tribanocci {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }

    private int helper(int n,int[] dp){
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        int two = 0;
        int three = 0;
        if (n > 1) two = tribonacci(n-2);
        if (n > 2) three = tribonacci(n-3);
        return dp[n] = tribonacci(n-1) +two + three;
    }
}
