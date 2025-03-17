package days;


import java.util.*;

public class Sunday {

    int leftBorder;

    /*
    You are given a string s and a positive integer k.
Select a set of non-overlapping substrings from the string s that satisfy the following conditions:
The length of each substring is at least k.
Each substring is a palindrome.
Return the maximum number of substrings in an optimal selection.
A substring is a contiguous sequence of characters within a string.
     */
    public int maxPalindromes(String s, int k) {
        int length = s.length();
        int count = 0;
        this.leftBorder = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            count += countPalindrome(s,i,i,k);
            count += countPalindrome(s,i,i+1,k);
        }
        return count;
    }

    private int countPalindrome(String s, int left, int right, int k) {
        int count = 0;
        boolean found = false;
        int n = s.length();
        while (left >= 0 && left > leftBorder && right < n && s.charAt(right) == s.charAt(left)){
            if (right - left + 1 >= k){
                count++;
                found = true;
                break;
            }
            left--;
            right++;
        }
        if (found)
            this.leftBorder = right;
        return count;
    }


    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int write = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                for (int j = i; j > write; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[write++] = temp;
            }
        }
        for (int i = write; i < n; i++) {
            if (nums[i] == pivot) {
                int temp = nums[i];
                for (int j = i; j > write; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[write++] = temp;
            }
        }

        return nums;
    }

    public static void moveInPlace(int[] arr, Set<Integer> set){
        int index = arr.length-1;
        for (int i = arr.length-1; i >= 0; i--) {
            if (set.contains(arr[i])){
                int temp = arr[i];
                for (int j = i; j < index; j++) {
                    arr[j] = arr[j+1];
                }
                arr[index--] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        moveInPlace(new int[]{1,4,6,3,5,7,2,1,7,53,3,2,1}, new HashSet<>(Arrays.asList(2,4,6,3)));
    }
        public static int nthSuperUglyNumber(int n, int[] primes) {
            // Priority queue to get the smallest current number
            PriorityQueue<long[]> minPQ = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
            for (int prime : primes) {
                minPQ.offer(new long[] {prime, 0, prime});
            }
            long[] output = new long[n];
            output[0] = 1;
            for (int i = 1; i < n; i++) {
                long[] current = minPQ.poll();
                long value = current[0];
                int idx = (int)current[1];
                long prime = current[2];
                if (value != output[i - 1]) {
                    output[i] = value;
                } else {
                    i--;
                }

                minPQ.offer(new long[] {output[idx + 1] * prime, idx + 1, prime});
            }

            return (int)output[n - 1];
        }



    public int getSum(int a, int b) {

        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }
}
