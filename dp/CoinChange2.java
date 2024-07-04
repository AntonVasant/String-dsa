package dp;

import java.util.Arrays;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] s : dp)
            Arrays.fill(s,-1);
        return helper(amount,dp,coins,coins.length-1,0);
    }

    private int helper(int target,int[][] dp,int[] coins,int index,int sum){
        if(index < 0) return sum == target ? 1 : 0;
        if(dp[index][sum] != -1) return dp[index][sum];
        int ans = 0;
        if(sum + coins[index] <= target){
            ans += helper(target,dp,coins,index,sum+coins[index]);
        }
        ans += helper(target,dp,coins,index-1,sum);
        return dp[index][sum] = ans;
    }
}
