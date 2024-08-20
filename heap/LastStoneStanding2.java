package heap;

import java.util.HashMap;
import java.util.Map;

public class LastStoneStanding2 {
    Map<String,Integer> map = new HashMap<>();
    public int lastStoneWeightII(int[] stones) {
        return helper(stones,0,0,0);
    }

    private int helper(int[] array,int index,int sum1,int sum2){
        if (index == array.length)
            return Math.abs(sum1-sum2);
        String key = index +" ,"+sum1+","+sum2;
        if (map.containsKey(key))
            return map.get(key);
        int option1 = helper(array, index+1, sum1+array[index], sum2);
        int option2 = helper(array, index+1, sum1, sum2+array[index]);
        int ans  = Math.min(option1,option2);
        map.put(key,ans);
        return ans;
    }
}
