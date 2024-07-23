package dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = helper(coins,amount,coins.length-1,dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
    private int helper(int[] array,int amount,int index,int[][] dp){
        if (amount == 0) return 0;
        if (index < 0) return (int)1e9;
        if(dp[index][amount] != -1) return dp[index][amount];
        int take = (int)1e9;
        if(array[index] <= amount){
            take = 1 + helper(array,amount - array[index],index,dp);
        }
        int nonTake =  helper(array,amount,index-1,dp);
        return dp[index][amount] = Math.min(take,nonTake);
    }
}
