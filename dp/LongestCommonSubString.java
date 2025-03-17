package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubString {
    static int longestCommonSubstrs(String S1, String S2){
        return helper(S1,S2,0,0,0,new HashMap<>());
    }
    private static int helper(String s1, String s2, int index1, int index2, int ans, Map<String,Integer> map){
        if (index1 == s1.length() || index2 == s2.length()) return ans;
        String key = index1+","+index2+","+ans;
        if (map.containsKey(key))
            return map.get(key);
        int take = ans;
        if (s1.charAt(index1) == s2.charAt(index2)){
            take = helper(s1, s2, index1+1, index2+1, ans+1, map);
        }
        int non1 = helper(s1, s2, index1+1, index2, 0, map);
        int non2 = helper(s1, s2, index1, index2+1, 0, map);
        int an = Math.max(non1,Math.max(take,non2));
        map.put(key,an);
        return an;
    }
    public static String longestCommonSubstr(String str1, String str2) {
        int f = str1.length();
        int s = str2.length();
        int[][] dp = new int[f+1][s+1];
        int start = 0;
        int maxLen = 0;
        for (int i = 1; i <= f; i++){
            for (int j = 1; j <= s; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        start = i - 1;
                    }
                }
                else dp[i][j] = 0;
            }
        }
        if (maxLen == 0) return "";
        return str1.substring(start - maxLen+1,start+1);
    }
    public static String shortestCommonSupersequence(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        for (int[] arr : dp)
            System.out.println(Arrays.toString(arr));
       int i = n;
        int j = m;
        StringBuilder builder = new StringBuilder();
        while (i > 0 && j > 0){
            if (str1.charAt(i-1) == str2.charAt(j-1)){
                builder.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]){
                builder.append(str1.charAt(i-1));
                i--;
            }
            else {
                builder.append(str2.charAt(j-1));
                j--;
            }
        }

        while (i > 0){
            builder.append(str1.charAt(i-1));
            i--;
        }

        while (j > 0){
            builder.append(str2.charAt(j-1));
            j--;
        }

        return builder.reverse().toString();
    }



    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("Anton", "aiviebfAnton"));
    }
}
