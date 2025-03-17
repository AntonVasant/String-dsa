package dp;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDistinctSubSequence {
        int distinctSubsequences(String S) {
            Map<Character,Integer> map = new HashMap<>();
            int n = S.length();
            int[] dp = new int[n+1];
            int MOD = 1000000007;
            for (int i = 1; i <= n; i++){
                char c  = S.charAt(i-1);
                dp[i] = (2 * dp[i-1]) %MOD;

                if (map.containsKey(c)){
                    int index = map.get(c);
                    dp[i] = (dp[i] - dp[index-1] + MOD) %MOD;
                }

                map.put(c,i);
            }
            return dp[n];
        }
}

//Input:
//s = "gfg"
//Output:
//        7
//Explanation:
//The seven distinct subsequences are "", "g", "f", "gf", "fg", "gg" and "gfg" .
//Example 2:
//
//Input:
//s = "ggg"
//Output:
//        4
//Explanation:
//The four distinct subsequences are "", "g", "gg", "ggg".
