package days;

import java.util.*;

public class Three {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (int n : spaces){
            builder.append(s.substring(i,n));
            builder.append(" ");
            i = n;
        }
        if (i < s.length())
            builder.append(s.substring(i));
        return builder.toString();
    }

    static int threeSumClosest(int[] array, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(array);
        int value = 0;
        int n = array.length;
        for (int i = 0; i < n - 2; i++){
            int j = i + 1;
            int k = n - 1;
            while (j < k){
                int sum = array[i] + array[j] + array[k];
                int diff = Math.abs(sum - target);
                if (diff < ans || diff == ans && sum > value){
                    ans = diff;
                    value = sum;
                }
                if (sum > target)
                    k--;
                else j++;
            }
        }
        return ans;
    }

    public static int dominantPairs(int n, int[] arr) {
        int mid = n/2;
        Arrays.sort(arr,0,mid);
        Arrays.sort(arr,mid,n);
        int j = mid;
        int ans = 0;
        for (int i = 0; i < mid; i++) {
            while (j < n && arr[i] >= 5 * arr[j])
                j++;
            ans += (j - mid);
        }
        return ans;
    }
    static long countSubarrys(long n){
            return n * (n + 1) / 2;
        }
    public static long countSubarrays(int[] a, int n, int L, int R){
            long res = 0;
            long exc = 0, inc = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] > R) {
                    res += (countSubarrys(inc) - countSubarrys(exc));
                    inc = 0;
                    exc = 0;
                }
                else if (a[i] < L) {
                    exc++;
                    inc++;
                }
                else {
                    res -= countSubarrys(exc);
                    exc = 0;
                    inc++;
                }
            }
            res += (countSubarrys(inc) - countSubarrys(exc));
            return res;
        }
    public static int appleSequence(int n, int m, String arr){
        int ans = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++){
            map.put(arr.charAt(right), map.getOrDefault(arr.charAt(right),0)+1);
            while (map.containsKey('O') && map.get('O') > m){
                char c = arr.charAt(left);
                map.put(c, map.getOrDefault(c, 0)-1);
                if (map.get(c) == 0)
                    map.remove(c);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int countIncreasing(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int length = 1;
        for (int i = 0; i < n-1; i++){
            if (arr[i] < arr[i+1])
                length++;
            else {
                if (length > 1){
                    ans += (length * (length-1))/2;
                    length = 1;
                }
            }
        }
        if (length > 1)
            ans += (length * (length-1))/2;
        return ans;
    }
    public int minMeetingRooms(int[] start, int[] end) {
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int endPointer = 0;
        for (int i : start) {
            if (i <= end[endPointer])
                endPointer++;
            else rooms++;
        }
        return rooms;
    }
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] == 0) continue;
            int slow = i;
            int fast = next(i, i, nums);
            while (nums[fast] * nums[i] > 0 && nums[next(fast, fast, nums)] * nums[i] > 0){
                if (slow == fast){
                    if (slow == next(slow, slow, nums)) break;
                    return true;
                }

                slow = next(slow , slow, nums);
                fast = next(fast,fast,nums);
                fast = next(fast,fast,nums);
            }

            int value = nums[i];
            slow = i;
            while (value * nums[slow] > 0){
                int pointer = next(slow,slow,nums);
                nums[slow] = 0;
                slow = pointer;
            }
        }
        return false;
    }
    private int next(int current, int pos, int[] arr){
        int n = arr.length;
        return (current + arr[pos] % n + n) % n;
    }


    /*
    Given a binary string s, return the number of non-empty substrings that have
    the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
    Substrings that occur multiple times are counted the number of times they occur.
     */
    public int countBinarySubstrings(String s) {
        int prev = 0;
        int current = 1;
        int count = 0;
        int n = s.length();
        for (int i = 1; i < n; i++){
            if (s.charAt(i) == s.charAt(i-1))
                current++;
            else {
                count += Math.min(current, prev);
                prev = current;
                current = 1;
            }
        }
        count += Math.min(current, prev);
        return count;
    }

    public static void main(String arg[]){
        Three three = new Three();
    }
}
