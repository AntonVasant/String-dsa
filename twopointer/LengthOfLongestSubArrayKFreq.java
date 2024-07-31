package twopointer;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubArrayKFreq {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int len = 0;
        for (int right = 0; right < nums.length; right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while (map.get(nums[right]) > k){
                map.put(nums[left],map.get(nums[left]) -1);
                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
            len = Math.max(len,right-left+1);
        }
        return len;
    }
}
