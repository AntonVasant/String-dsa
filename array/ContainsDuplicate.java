package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
