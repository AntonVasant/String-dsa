package dp;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak{
    public int integerBreak(int n) {
        Map<Integer,Integer> dp = new HashMap<>();
        return helper(n,dp);
    }

    private int helper(int n,Map<Integer,Integer> map){
        if (n == 1 || n == 2) return 1;
        if (map.containsKey(n))
            return map.get(n);
        int ans = 0;
        for (int i = 1; i <= n; i++){
            ans = Math.max(ans,Math.max(i*(n-1),i*helper(n-i,map)));
        }
        map.put(n,ans);
        return ans;
    }
}
