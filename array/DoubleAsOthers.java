package array;

import java.util.HashMap;
import java.util.Map;

public class DoubleAsOthers {
    public int dominantIndex(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int first = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > first){
                sec = first;
                first = nums[i];
            } else if (nums[i] > sec) {
                sec = nums[i];
            }
            map.put(nums[i],i);
        }
        if (sec *2 <= first)
            return map.get(first);
        else return -1;
    }
}
