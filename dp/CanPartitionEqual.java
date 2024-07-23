package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanPartitionEqual {
    public boolean canPartition(int[] nums) {
        Map<String,Boolean> map = new HashMap<>();
        int total = Arrays.stream(nums).sum();
        if(total %2 != 0) return false;
        int target = total/2;
        return helper(nums,target,0,map);
    }

    private boolean helper(int[] nums,int target,int index,Map<String,Boolean> map){
        if (target == 0) return true;
        if(index == nums.length)
            return target == 0;
        String key = index+","+target;
        if (map.containsKey(key)) return map.get(key);

        boolean first = helper(nums,target-nums[index],index+1,map);

        boolean second = helper(nums,target,index+1,map);
        map.put(key,first ||second);
        return first || second;
    }
}
