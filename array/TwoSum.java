package array;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public int[] twoSum(int[] array ,int target){
        Set<Integer> set = new HashSet<>();
        for(int num : array){
            set.add(num);
            if(set.contains(target-num))
                return new int[]{num,target-num};
        }
        return null;
    }
}
