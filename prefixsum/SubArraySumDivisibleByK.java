package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int prefix = 0;
        for (int num : nums){
            prefix += num;
            int rem = prefix%k;
            if (rem < 0)
                rem += k;
            if (map.containsKey(rem))
                count += map.get(rem);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}
