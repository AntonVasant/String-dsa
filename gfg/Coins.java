package gfg;

import java.util.*;

public class Coins {
    public long count(int coins[], int sum) {
        int n = coins.length;
        long[][] dp = new long[n+1][sum+1];
        for (long[] l : dp)
            Arrays.fill(l,-1);
        return helper(coins,0,sum,dp);
    }


    private long helper(int[] coins,int index, int target, long[][] dp){
        if (target == 0) return 1;
        if (index == coins.length || target < 0) return 0;
        if (dp[index][target] != -1) return dp[index][target];
        long ans = helper(coins, index, target - coins[index], dp) + helper(coins, index+1, target, dp);
        dp[index][target] = ans;
        return ans;
    }

    public static int findLongestConseqSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int n : arr)
            set.add(n);
        for (int n : arr){
            if (!set.contains(n-1)){
                int num = n;
                int ans = 0;
                while (set.contains(num)){
                    num++;
                    ans++;
                    max = Math.max(max,ans);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(findLongestConseqSubseq(new int[]{2, 6, 1, 9, 4, 5, 32, 6, 1, 9, 4, 5, 3}));
    }
}
