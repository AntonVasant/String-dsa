package twopointer;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinctElements {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }

    private int helper(int[] array,int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        for(int right = 0; right < array.length; right++){
            map.put(array[right],map.getOrDefault(array[right],0)+1);
            while (map.size() > k){
                map.put(array[left],map.get(array[left])-1);
                if (map.get(array[left]) == 0){
                    map.remove(array[left]);
                }
                left++;
            }
            count += right - left +1;
        }
        return count;
    }
}
