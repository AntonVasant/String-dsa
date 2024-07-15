package dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,new Comparator<int[]>(){
                    public int compare(int[] a,int[] b){
                        if (a[0] == b[0])
                            return b[1] - a[1];
                        return a[0] - b[0];
                    }
                }
        );
        int n = envelopes.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            res[i] =  envelopes[i][1];
        }
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp)
            Arrays.fill(arr,-1);
        return longest(res,0,-1,dp);
    }

    private int longest(int[] array,int index,int prev,int[][] dp){
        if (index == array.length) return 0;
        if (dp[index][prev+1] != -1) return dp[index][prev+1];
        int take = 0;
        if (prev == -1 || array[index] > array[prev]){
            take = 1 + longest(array,index+1,index,dp);
        }
        int non = longest(array,index+1,prev,dp);
        int ans = Math.max(take,non);
        dp[index][prev+1] = ans;
        return ans;
    }
}
