package rescursion;

public class TotalDecodeString {

    public int CountWays(String str){
        int n = str.length();
        int[] dp = new int[n+1];
        if (str.isEmpty() || str.charAt(0) == '0') return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            int one = Integer.parseInt(str.substring(i-1,i));
            int two = Integer.parseInt(str.substring(i-2,i));
            if (one > 0)
                dp[i] += dp[i-1];
            if (two >= 10 && two <= 26)
                dp[i] += dp[i-1];
        }
        return dp[n];
    }

}
