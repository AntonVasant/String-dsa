package array;

import java.util.Arrays;
import java.util.Stack;

public class FlowerBed {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++){
            if (flowerbed[i] == 0){
                boolean left = (i == 0 || flowerbed[i-1] == 0);
                boolean right = (i == flowerbed.length-1 || flowerbed[i+1] == 0);
                if (left && right){
                    n--;
                    if (n == 0) return true;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }

    int[] nearestSmallestTower(int [] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right, -1);
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                right[stack.pop()] = i;
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                left[stack.pop()] = i;
            stack.push(i);
        }
        for (int i = 0; i < n; i++){
            int leftIndex = left[i] < 0 ? Integer.MAX_VALUE : Math.abs(left[i] - i);
            int rightIndex = right[i] < 0 ? Integer.MAX_VALUE : Math.abs(right[i] - i);
            if (leftIndex < rightIndex)
                right[i] = left[i];
            else {
                if (left[i] != -1 && right[i] != -1)
                    right[i] = arr[right[i]] > arr[left[i]] ? left[i] : right[i];
                else if (right[i] != -1)
                    right[i] = left[i];
                else right[i] = -1;
            }
        }
        System.out.println(Arrays.toString(right));
        return right;
    }

    /*
    Given an integer array nums and two integers left and right, return the number of contiguous
    non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        int smaller = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                smaller = i - j + 1;
                ans += smaller;
            }
            else if (nums[i] < left) {
                ans += smaller;
            }
            else {
                smaller = 0;
                j = i + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        FlowerBed flowerBed = new FlowerBed();
        flowerBed.nearestSmallestTower(new int[]{4,8,3,5,3});
    }
}
