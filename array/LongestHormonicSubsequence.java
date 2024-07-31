package array;

import java.util.HashMap;
import java.util.Map;

public class LongestHormonicSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);
        int length = 0;
        for (int num : map.keySet()){
            if (map.containsKey(num+1)){
                int distance = map.get(num) + map.get(num+1);
                length = Math.max(length,distance);
            }
        }
        return length;
    }
}
