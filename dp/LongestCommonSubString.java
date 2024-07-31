package dp;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubString {
    int longestCommonSubstr(String S1, String S2, int n, int m){
        return helper(S1,S2,0,0,0,new HashMap<>());
    }

    private int helper(String s1, String s2, int index1, int index2, int ans, Map<String,Integer> map){
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
}
