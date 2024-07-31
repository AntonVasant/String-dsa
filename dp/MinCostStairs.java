package dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostStairs {
    public int minCostClimbingStairs(int[] cost) {
        Map<String,Integer> map = new HashMap<>();
        int one = helper (new HashMap<>(),0,cost);
        int two = helper (new HashMap<>(),1,cost);
        return Math.min(one,two);
    }


    private int helper(Map<String,Integer> map ,int index,int[] array){
        if (index == array.length) return 0;
        String key = index+",";
        if (map.containsKey(key))
            return map.get(key);
        int one = array[index] + helper(map, index+1, array);
        int two = Integer.MAX_VALUE;
        if (index+2 < array.length)
          two = array[index]+ helper(map, index+2, array);
        int ans = Math.min(one,two);
        map.put(key,ans);
        return ans;
    }
}
