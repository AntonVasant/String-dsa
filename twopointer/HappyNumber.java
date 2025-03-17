package twopointer;

import java.io.IOException;
import java.util.*;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 0){
            int d = helper(n);
            if (set.contains(d)) return false;
            set.add(d);
            System.out.println(d);
            if (d == 1) return true;
            n = d;
        }
        return false;
    }

    private int helper(int n){
        int ans = 0;
        while (n > 0){
            int digit = n%10;
            ans += digit*digit;
            n/= 10;
        }
        return ans;
    }

    public static int shortestSubarray(int[] nums, int k) {
        long[] prefixSum = new long[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int result = Integer.MAX_VALUE;

        Deque<Integer> potentialStartIndices = new LinkedList<>();

        for (int i = 0; i < prefixSum.length; i++) {
            while (!potentialStartIndices.isEmpty() && prefixSum[i] - prefixSum[potentialStartIndices.peekFirst()] >= k) {
                result = Math.min(result, i - potentialStartIndices.pollFirst());
            }

            while (!potentialStartIndices.isEmpty() && prefixSum[i] <= prefixSum[potentialStartIndices.peekLast()]) {
                potentialStartIndices.pollLast();
            }

            potentialStartIndices.addLast(i);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int numberOfAlternatingGroups(int[] nums, int k)   {
        int n = nums.length;
        int[] arr = new int[n + n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            arr[i + n] = nums[i];
        }
        int right = 0;
        int left = 0;
        int count = 0;
        while (left <  n){
            if (right - left != k - 1 && arr[right] != arr[right + 1])
                right++;
            else if (right - left != k - 1 && arr[right] == arr[right + 1]){
                left = right + 1;
                right++;
            }

            if (right - left == k - 1){
                count++;
                left++;
            }
        }
        return count;
    }


    /*
There is a bookstore owner that has a store open for n minutes. You are given an integer array customers of length n
where customers[i] is the number of the customers that enter the store at the start of the ith minute and all those
customers leave after the end of that minute.
During certain minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the
bookstore owner is grumpy during the ith minute, and is 0 otherwise.
When the bookstore owner is grumpy, the customers entering during that minute are not satisfied. Otherwise, they are satisfied.
The bookstore owner knows a secret technique to remain not grumpy for minutes consecutive minutes, but this technique can
only be used once.
Return the maximum number of customers that can be satisfied throughout the day.
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalHappyCustomers = 0;
        int maxDis = 0;
        int curDis = 0;
        int n = customers.length;
        int left = 0;
        int right = 0;
        while (left < n - (minutes-1) && right < n){
            if (grumpy[right] == 0)
                totalHappyCustomers += customers[right];
            else curDis += customers[right];

            if (right - left + 1 == minutes){
                maxDis = Math.max(maxDis, curDis);
                if (grumpy[left] == 1){
                    curDis -= customers[left];
                }
                left++;
            }
            right++;
        }
        return totalHappyCustomers + maxDis;
    }

    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }



}
