package twopointer;

import java.util.HashMap;
import java.util.Map;

public class KDifferentPairs {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n,0)+1);
        int count = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (k == 0){
                if (entry.getValue() > 1) count++;
            }
            else {
                if (map.containsKey(k+entry.getKey())) count++;
            }
        }
        return count;
    }
}
