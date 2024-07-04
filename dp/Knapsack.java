package dp;

import java.util.Arrays;

public class Knapsack {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        return helper(wt,val,dp,0,W);
    }


    private static int helper(int[] W,int[] val,int[] dp,int index,int current){
        if(index == val.length) return 0;
        if(dp[index] != -1) return dp[index];
        int take = Integer.MIN_VALUE;
        if(W[index] <= current){
            take = val[index] + helper(W,val,dp,index+1,current - W[index]);
        }
        dp[index] = Math.max(take,helper(W,val,dp,index+1,current));
        return dp[index];
    }
}
