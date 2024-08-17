package array;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int k : nums1) {
            for (int i : nums2) {
                int sum = k + i;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int ans = 0;
        for (int k : nums3) {
            for (int i : nums4) {
                int sum = -(k + i);
                ans += map.getOrDefault(sum, 0);
            }
        }
        return ans;
    }
}
