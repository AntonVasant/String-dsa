package array;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ContigousArrayWithEqual01 {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int right = 0; right < nums.length; right++){
            sum += nums[right] == 1 ? 1 : -1;
            if (map.containsKey(sum))
                len = Math.max(len,right - map.get(sum));
            else map.put(sum,right);
        }
        return len;
    }
}
