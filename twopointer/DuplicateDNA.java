package twopointer;

import java.util.*;

public class DuplicateDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for(int i = 0; i <= s.length()-10;i++){
            String str = s.substring(i,i+10);
            if(seen.contains(str)){
                ans.add(str);
            }seen.add(str);
        }
        for(String str : ans){
            list.add(str);
        }
        return list;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int pointer1 = 0;
        int pointer2 = 1;
        if (n < 3) return 0;
        int ans = 0;
        int difference = nums[pointer2] - nums[pointer1];
        while (pointer2 <= n) {

            if (pointer2 != n && nums[pointer2] - nums[pointer2-1] == difference)
                pointer2++;
            else {
                if (pointer2 - pointer1 >= 3){
                    int length = pointer2 - pointer1 - 2;
                    ans += length * (length - 1)/2;
                }

                pointer1 = pointer2 - 1;
                if (pointer2 == n) break;
                difference = nums[pointer2] - nums[pointer1];
            }
        }
        return ans;
    }
    //1234 -> needs work
    public static int balancedString(String s) {
        int [] arr = new int[4];
        String ss = "EQRW";
        for(int i=0;i<s.length();++i){
            arr[ss.indexOf(s.charAt(i))]++;
        }
        int m = s.length()/4;
        if(arr[0]==m&&arr[1]==m&&arr[2]==m&&arr[3]==m) return 0;

        int ans = s.length();
        for(int i=0,j=0;i<s.length();++i){
            arr[ss.indexOf(s.charAt(i))]--;
            while(j<=i && arr[0] <= m && arr[1] <= m && arr[2] <= m && arr[3] <= m){
                ans = Math.min(ans,i-j+1);
                arr[ss.indexOf(s.charAt(j++))]++;
            }
        }
        return ans;
    }
    public int longestBeautifulSubstring(String word) {
        Map<Character, Character> order = Map.of(
                'a','e',
                'e','i',
                'i','o',
                'o','u',
                'u','u'
        );

        int ans = 0;
        int right = 0;
        int n = word.length();
        while (right < n && word.charAt(right) != 'a')
            right++;
        int left = right;
        char currentChar;
        int count  = 0;
        char prev = ' ';
        while (right < n){
            currentChar = word.charAt(right);
            if (prev == ' ' || currentChar == order.get(prev)){
                while (right < n && word.charAt(right) == currentChar)
                    right++;
                prev = currentChar;
                count++;
            }
            else {
                count = 0;
                prev = ' ';
                left = right;
            }

            if (count == 5) {
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }
    //length of non overlapping two sub arrays whose sum is target
    public int minSumOfLengths(int[] arr, int target) {
        int length = arr.length;
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int left = 0;
        int minSoFar = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < length; right++){
            sum += arr[right];

            while (left <= right && sum > target){
                sum -= arr[left++];
            }

            if (sum == target){
                int currentLength = right - left + 1;
                if (left > 0 && dp[left -1] != Integer.MAX_VALUE){
                    result = Math.min(result, currentLength + dp[left-1]);
                }

                minLength = Math.min(minLength, currentLength);
            }

            dp[right] = minLength;
            minSoFar = Math.min(minSoFar, dp[right]);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
