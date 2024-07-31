package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistinctNumbers {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++){
            if (i < nums2.length && nums1[i] != nums2[i])
                list1.add(nums1[i]);
        }
        list.add(list1);
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++){
            if (i < nums1.length && nums1[i] != nums2[i])
                list2.add(nums1[i]);
        }
        list.add(list2);
        return list;
    }
}
