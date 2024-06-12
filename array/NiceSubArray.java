package array;

import java.util.HashMap;
import java.util.Map;

public class NiceSubArray {
    public int numberOfSubarrays(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        int remove = 0;
        for(int i = 0; i < nums.length;i++){
            nums[i] = (nums[i]%2 == 0) ? 0 : 1;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int right = 0;
        map.put(0,1);
        while(right < nums.length){
            sum += nums[right];
            remove = sum - k;
            ans += map.getOrDefault(remove,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
            right++;
        }
        return ans;
    }  // converted the problem  to k sum sub array
}
