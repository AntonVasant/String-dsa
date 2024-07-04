package array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int remove = sum - k;
            if(map.containsKey(remove)){
                count += map.get(remove);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
