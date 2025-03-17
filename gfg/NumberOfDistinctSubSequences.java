package gfg;

import java.util.Arrays;

public class NumberOfDistinctSubSequences {
    int distinctSubsequences(String S) {
        int n = S.length();
        int[] dp = new int[n+1];
        int[] last = new int[26];
        Arrays.fill(last,-1);
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            char c = S.charAt(i);
            dp[i] = 2 * dp[i-1];
            if (last[c-'0'] != -1){
                dp[i] -= dp[last[c-'0']];
            }
            last[c-'0'] = i-1;
        }
        return dp[n];
    }

    boolean kPangram(String str, int k) {
        if (str.length() < 26) return false;
        boolean[] ans = new boolean[26];
        Arrays.fill(ans,false);
        for (char c : str.toCharArray()){
            if (Character.isLetter(c))
                ans[c-'a'] = true;
        }
        for (boolean b : ans){
            if (!b){
                k--;
                if (k == 0) return false;
            }
        }
        return true;
    }
}
