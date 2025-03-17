package dp;

public class WildCardMatching {
    public boolean isMatch(String s, String p){
        int index1 = s.length()-1;
        int index2 = p.length()-1;
        Boolean[][] dp = new Boolean[index1 + 2][index2 + 2];
        return helper(s,p,index1,index2,dp);
    }

    private boolean helper(String s,String p,int index1,int index2,Boolean[][] dp){
        if(index1 < 0 && index2 < 0) return true;
        if(index2 < 0) return false;
        if(index1 < 0){
            for(int i = index2; i >= 0; i--){
                if(p.charAt(i) != '*') return false;
            }
            return true;
        }
        if(dp[index1][index2] != null) return dp[index1][index2];
        if(s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '?')
            return dp[index1][index2] = helper(s,p,index1-1,index2-1,dp);
        if(p.charAt(index2) == '*')
            return dp[index1][index2] = helper(s,p,index1,index2-1,dp) || helper(s,p,index1-1,index2,dp);
        return dp[index1][index2] = false;
    }
}
