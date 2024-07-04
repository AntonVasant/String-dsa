package dp;

import java.util.Arrays;

public class DistinctSubsequence {
    public int numDistinct(String s, String t) {
        int index1 = s.length();
        int index2 = t.length();
        int[][] dp = new int[index1+1][index2+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s,t,dp,index1-1,index2-1);
    }

    public int helper(String str1,String str2,int[][] dp,int index1,int index2){
        if(index2 < 0) return 1;
        if(index1 < 0) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(str1.charAt(index1) == str2.charAt(index2)){
            return dp[index1][index2] = helper(str1,str2,dp,index1-1,index2-1)
                    + helper(str1,str2,dp,index1-1,index2);
        }
        else dp[index1][index2] = helper(str1,str2,dp,index1-1,index2);
        return  dp[index1][index2];
    }
}
