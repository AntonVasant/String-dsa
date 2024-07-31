package dp;

import java.util.HashMap;
import java.util.Map;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
            int inc = helper(new HashMap<>(),nums,true,0,-1);
            int dec  = helper(new HashMap<>(),nums,false,0,Integer.MAX_VALUE);
            return Math.max(inc,dec);
    }

    private int helper(Map<String,Integer> map,int[] array,boolean isIncrease,int index,int prev){
        if (index == array.length) return 0;
        String key = index+","+isIncrease+","+prev;
        if (map.containsKey(key))
            return map.get(key);
        int take = 0;
        if (isIncrease){
            if (array[index] > prev){
                take = 1 + helper(map, array, !isIncrease, index+1, array[index]);
            }
        } else if (!isIncrease) {
            if (array[index] < prev){
                take = 1 + helper(map, array, !isIncrease, index+1, array[index]);
            }
        }
        int non = helper(map, array, isIncrease, index+1, prev);
        int ans = Math.max(take,non);
        map.put(key,ans);
        return ans;
    }
}
