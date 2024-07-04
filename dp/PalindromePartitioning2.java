package dp;

import java.util.Arrays;

public class PalindromePartitioning2 {
    public int minCut(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(s,0,dp)-1;
    }

    private int helper(String s,int index,int[] dp){
        if(index >= s.length()) return 0;
        if(dp[index] != -1) return dp[index];
        int partitions = Integer.MAX_VALUE;
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                partitions = Math.min((1 + helper(s,i+1,dp)),partitions);
            }
        }
        return dp[index] = partitions;
    }
    private boolean isPalindrome(String s,int low,int high){
        while(low < high){
            if(s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
