package string;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int len = 0;
        int start = nums[0];
        int i;
        for (i = 1; i < n; i++){
            if (nums[i] == nums[i-1]+1){
                len++;
                continue;
            }
            if (len == 0){
                list.add(String.valueOf(nums[start]));
            }
            else {
                String add = nums[start] +"->"+nums[i-1];
                list.add(add);
            }
            start=i;
            len = 0;
        }
        if (start == n-1) list.add(String.valueOf(nums[n-1]));
        else list.add(nums[start]+"->"+nums[n-1]);
        return list;
    }

    public static void main(String[] args) {
        SummaryRanges ranges = new SummaryRanges();
        List<String> list = ranges.summaryRanges(new int[]{0,2,3,4,6,8,9});
        System.out.println(list.toString());
    }
}
