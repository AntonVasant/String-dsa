package dp;

import java.util.Arrays;

public class MaximizeCuts {
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++){
            if (i >= x && dp[i-x] != Integer.MIN_VALUE)
                dp[i] = Math.max(dp[i],dp[i-x]+1);

            if (i >= y && dp[i-y] != Integer.MIN_VALUE)
                dp[i] = Math.max(dp[i],dp[i-y]+1);


            if (i >= z && dp[i-z] != Integer.MIN_VALUE)
                dp[i] = Math.max(dp[i],dp[i-z]+1);
        }
        return dp[n] == Integer.MIN_VALUE ? 0 : dp[n];
    }
}
