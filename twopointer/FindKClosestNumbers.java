package twopointer;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestNumbers {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;
        while (right - left >= k){
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x))
                left++;
            else right--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++){
            list.add(arr[i]);
        }
        return list;
    }
}
//leetcode