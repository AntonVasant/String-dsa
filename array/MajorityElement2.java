package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        int n = nums.length;
        for (int num : nums){
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
            else if (count1 == 0){
                candidate1 = num;
                count1 = 1;
            }
            else if (count2 == 0){
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums){
            if (num == candidate1)count1++;
            else if (num == candidate2) count2++;
        }
        if (count1 >= n/3) list.add(candidate1);
        if (count2 >= n/3) list.add(candidate2);
        return list;
    }
}
