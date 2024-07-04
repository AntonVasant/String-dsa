package dp;

import java.util.Arrays;

public class ZeroToN {
    public static int minOperation(int n)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,0,dp);
    }

    private static int helper(int n,int index,int[] dp){
        if(index == n) return 0;
        if(index > n) return (int)1e9;
        if(dp[index] != -1) return dp[index];
        int plus = 1 + helper(n,index+1,dp);
        int doubleNum = (int)1e9;
        if(index >= 2)
            doubleNum = 1 + helper(n,index*2,dp);
        return dp[index] = Math.min(plus,doubleNum);
    }
}
