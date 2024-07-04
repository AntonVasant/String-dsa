package dp;

import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings {
    public boolean isInterleave(String s1, String s2, String s3) {
        return helper(s1,s2,s3,0,0,0,new HashMap<>());
    }


    private boolean helper(String s1, String s2, String s3, int i, int j, int k, Map<String,Boolean> dp){
        String key = i+","+j+","+k;
        if(i == s1.length() && j == s2.length() && k == s3.length()) return true;
        if(dp.containsKey(key)) return dp.get(key);
        if(k == s3.length()) return false;

        Boolean match1 = (i < s1.length() && s1.charAt(i) == s3.charAt(k) && helper(s1,s2,s3,i+1,j,k+1,dp));
        Boolean match2 = (j < s2.length() && s2.charAt(j) == s3.charAt(k) && helper(s1,s2,s3,i,j+1,k+1,dp));
        boolean res = match1 || match2;
        dp.put(key,res);
        return res;
    }
}
