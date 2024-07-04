package rescursion;

import java.util.Arrays;

public class DecodeWays {
    public static int decode(String s){
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(s,0,dp);
    }

    private static int helper(String s,int index,int[] dp){
        if (index == s.length()) return 1;
        if (dp[index] != -1) return dp[index];
        int ways = helper(s,index+1,dp);
        if (index+1 < s.length() && validate(s.substring(index,index+2)))
            ways += helper(s, index+2,dp);
        return dp[index] = ways;
    }

    private static boolean validate(String str){
        int n = Integer.parseInt(str);
        return n >= 10 && n <= 26;
    }
}
