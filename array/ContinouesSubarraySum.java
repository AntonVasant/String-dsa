package array;

import java.util.HashMap;
import java.util.Map;

public class ContinouesSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0,-1);
        int remainder = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            remainder = sum%k;
            if (remainder < 0) remainder += k;
            if (map.containsKey(remainder)){
                if (i - map.get(remainder) > 1)
                    return true;
            }else {
                map.put(remainder,i);
            }
        }
        return false;
    }
}
