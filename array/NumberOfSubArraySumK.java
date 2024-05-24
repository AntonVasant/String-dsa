package array;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArraySumK {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int remove = 0;
        int result =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            remove = sum - goal;
            result += map.getOrDefault(remove,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return result;
    }
}
