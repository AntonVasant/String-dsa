package dp;

import java.util.HashMap;
import java.util.Map;

public class DeleteEarn {
    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = 0;
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+num);
            n = Math.max(n,num);
        }
        return helper(map,n,new HashMap<>());
    }

    private int helper(Map<Integer,Integer> map,int n,Map<Integer,Integer> memo){
        if (n == 0) return 0;
        if (n == 1)  return map.getOrDefault(1,0);
        if (memo.containsKey(n)) return memo.get(n);
        int point = map.getOrDefault(n,0);
        int ans = Math.max(helper(map,n-1,memo), point+helper(map, n-2, memo));
        memo.put(n,ans);
        return ans;
    }
}
