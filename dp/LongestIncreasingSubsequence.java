package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int longestSubsequence(int n, int a[]) {
        int[][] dp = new int[n+1][n+1];
        for(int[] s : dp)
            Arrays.fill(s,-1);
        return helper(a,0,-1,dp);
    }

    static int helper(int[] a,int index,int prev,int[][] dp){
        if(index == a.length) return 0;
        if(dp[index][prev+1] != -1) return dp[index][prev+1];
        int ans = 0;
        if (prev == -1 || a[index] > a[prev]){
            ans = 1 + helper(a,index+1,index,dp);
        }
        int non = helper(a,index+1,prev,dp);
        dp[index][prev+1] = Math.max(ans,non);
        return dp[index][prev+1];
    }

    public static int tabulation(int[] array,int n,int[][] dp){
        for (int index = n-1; index >=0; index--){
            for (int prev = index-1;prev >= -1; prev--){
                int len = dp[index+1][prev+1];
                if (prev == -1 || array[index] > array[prev+1]){
                    len = Math.max(len,1+dp[index+1][index]);
                }
                dp[index][prev+1] = len;
            }
        }
        return dp[0][0];
    }
}
