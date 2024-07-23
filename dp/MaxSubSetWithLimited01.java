package dp;

import java.util.HashMap;
import java.util.Map;

public class MaxSubSetWithLimited01 {
    public int findMaxForm(String[] strs, int m, int n) {
        Map<String,Integer> memo = new HashMap<>();
        return helper(strs,0,m,n,memo);
    }

    private int helper(String[] arr,int index, int m,int n,Map<String,Integer> memo){
        if (m < 0 || n < 0) return Integer.MIN_VALUE;
        if (index >= arr.length) return 0;
        String key = index+","+m+","+n;
        if (memo.containsKey(key))
            return memo.get(key);
        int[] res = helper2(arr[index]);
        int take = 1 + helper(arr,index+1,m-res[0],n-res[1],memo);
        int non = helper(arr,index+1,m,n,memo);
        int ans = Math.max(take,non);
        memo.put(key,ans);
        return ans;
    }

    private int[] helper2(String s){
        int ones = 0;
        int zeros = 0;
        for (char c : s.toCharArray()){
            if (c == '0') zeros++;
            else ones++;
        }
        return new int[]{zeros,ones};
    }
}
