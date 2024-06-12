package array;

import java.util.HashSet;
import java.util.Set;

public class Duplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> window = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++) {

            if(i > k) window.remove(nums[i - k - 1]);

            if(!window.add(nums[i])) return true;
        }

        return false;
    }
}
