package dp;

import java.util.Arrays;

public class CutRod {
    public int cutRod(int[] price, int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++){
            dp[i] = price[i-1];
            for (int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i],price[j-1] + dp[i-j]);
            }
        }
        return dp[n];
    }
}
