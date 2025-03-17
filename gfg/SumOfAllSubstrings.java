package gfg;

public class SumOfAllSubstrings {
    private static final int MOD = 1_000_000_007;
    public static long sumSubstrings(String s)
    {
        int n = s.length();
        long[] dp = new long[n];
        dp[0] = s.charAt(0) - '0';
        long sum = dp[0];
        for (int i = 1; i < n; i++){
            int digit = s.charAt(i) - '0';
            dp[i] = ((dp[i-1] * 10) + (long) (i + 1) * digit) % MOD;
            sum += dp[i]%MOD;
        }
        return sum;
    }




    static int minimumNumberOfDeletions(String S) {
        //your code here
        String s = new StringBuilder(S).reverse().toString();
        int n = s.length();
        int ans = tabulation(S,s);
        System.out.println(ans);
        return n - ans;
    }


    public static int tabulation(String str1,String str2){
        System.out.println(str1 +" "+str2);
        int n = str1.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] =  1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        System.out.println(minimumNumberOfDeletions("geeksforgeeks"));
    }
}
