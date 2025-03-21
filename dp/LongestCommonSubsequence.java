package dp;

public class LongestCommonSubsequence {
    public static int subSequence(String str1,String str2){
        return helper(str1,str2,0,0);
    }
    public static int helper(String str1,String str2,int index1,int index2){
        if (index1 == str1.length()|| index2 == str2.length()) return 0;
        if (str1.charAt(index1) == str2.charAt(index2))
            return 1 + helper(str1, str2, index1+1, index2+1);
        int first = helper(str1, str2, index1+1, index2);
        int second = helper(str1, str2, index1, index2+1);
        return Math.max(first,second);
    }

    int LCSof3(String A, String B, String C, int n1, int n2, int n3)
    {
        int[][][] dp = new int[n1+1][n2+1][n3+1];

        for (int i = 1; i <= n1; i++){
            for (int j = 1; j <= n2; j++){
                for (int k = 1; k <= n3; k++){
                    if (A.charAt(i-1) == B.charAt(j-1) && A.charAt(i-1) == C.charAt(k-1))
                        dp[i][j][k] = dp[i-1][j-1][k-1] +1;
                    else dp[i][j][k] = Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k],dp[i][j][k-1]));
                }
            }
        }
        return dp[n1][n2][n3];
    }

    public static int memoization(String str1,String str2,int index1,int index2,int[][] dp){
        if (index1 == str1.length() || index2 == str2.length()) return 0;
        if (dp[index1][index2] != -1) return dp[index1][index2];
        if (str1.charAt(index1) == str2.charAt(index2))
            return 1 + helper(str1, str2, index1+1, index2+1);
        int first = helper(str1, str2, index1+1, index2);
        int second = helper(str1, str2, index1, index2+1);
        return dp[index1][index2] = Math.max(first,second);
    }

    public static int tabulation(String str1,String str2,int[][] dp,int index1,int index2){
        for(int i = 0; i <= index1; i++) dp[i][0] = 0;
        for(int i = 0; i <= index2; i++) dp[0][i] = 0;
        for (int i = 1; i <= index1; i++){
            for (int j = 1; j <= index2; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] =  1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[index1][index2];
    }

    public static void printLCS(String str1,String str2,int index1,int index2,int[][] dp){
        for(int i = 0; i <= index1; i++) dp[i][0] = 0;
        for(int i = 0; i <= index2; i++) dp[0][i] = 0;
        for (int i = 1; i <= index1; i++) {
            for (int j = 1; j <= index2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
            int i = index1;
            int j = index2;
            StringBuilder sb = new StringBuilder();
            while (i > 0 && j > 0){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    sb.append(str1.charAt(i-1));
                    i--;
                    j--;
                } else if (dp[i-1][j] > dp[i][j-1]) {
                    i--;
                }else j--;

                }
        System.out.println(sb.reverse());
            }

}
