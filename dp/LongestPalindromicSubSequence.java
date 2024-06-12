package dp;

import string.Reverse;

public class LongestPalindromicSubSequence {

    public static int longestPalindromicSubSequence(String str1){
        int index1 = str1.length();
        String str2 = Reverse.reverse(str1);
        int[][] dp = new int[index1+1][index1+1];
        return longestPalindromeSequence(str1,str2,index1,index1,dp);
    }
    private   static int longestPalindromeSequence(String str1,String str2,int index1,int index2,int[][] dp){
        for (int i = 0; i <= index1; i++) dp[i][0] = 0;
        for (int i = 0; i <= index2; i++) dp[0][i] = 0;
        for (int i = 1; i <= index1; i++){
            for (int j = 1; j <= index2; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[index1][index2];
    }


}
