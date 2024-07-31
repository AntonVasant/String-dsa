package dp;

import java.util.HashMap;
import java.util.Map;

public class KnapSackDuplicate {
    static int knapSack(int N, int W, int val[], int wt[])
    {
        return helper(0,new HashMap<>(),val,wt,W);
    }

    private static int helper(int index, Map<String,Integer> map,int[] val,int[] wt,int w){
        if (index == val.length) return 0;
        String s = index+"."+w;
        if (map.containsKey(s))
            return map.get(s);
        int profit = 0;
        if (w >= wt[index]){
            profit = val[index] + helper(index, map, val, wt, w-wt[index]);
        }
        int non = helper(index+1, map, val, wt, w);
        int ans = Math.max(profit,non);
        map.put(s,ans);
        return ans;
    }
}
