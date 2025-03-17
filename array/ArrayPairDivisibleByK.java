package array;

import java.util.*;

public class ArrayPairDivisibleByK {

    public static int trap(int[] height) {
        int n  = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        for(int i = 1; i < n; i++){
            if(height[i-1] > max) max = height[i-1];
            left[i] = max;
        }

        max = 0;
        for (int i = n-2; i >= 0; i--){
            if(height[i+1] > max) max = height[i+1];
            right[i] = max;
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            int min = Math.min(left[i], right[i]);
            if((min - height[i]) > 0)
                ans += min - height[i];
        }
        return ans;
    }


    class pair  {
        long first, second;
        public pair(long first, long second)
        {
            this.first = first;
            this.second = second;
        }
    }

    public pair[] allPairs(int target, int[] arr1, int[] arr2) {
        List<List<Long>> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : arr2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int num : arr1) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                for (int i = 0; i < map.get(complement); i++) {
                    list.add(new ArrayList<>(Arrays.asList((long) complement,(long) target - num)));
                }
            }
        }
        pair[] ans = new pair[list.size()];

        for (int i= 0; i < list.size(); i++) {
            pair p = new pair(list.get(i).get(0), list.get(i).get(1));
            ans[i] = p;
        }
        return ans;
    }



    /*
    The method countPairs(int[] nums, int k) counts the number of pairs
     (i, j) where i < j and the product of nums[i] and nums[j] is divisible by k.
     */
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for (int num : nums){
            int gcd = gcd(num, k);
            for (int keys : map.keySet()){
                if ((long) keys * gcd % k == 0)
                    ans += map.get(keys);
            }
            map.put(gcd, map.getOrDefault(gcd,0)+1);
        }
        return ans;
    }
    private static int gcd(int a, int b){
       if (b == 0) return a;
       return gcd(b, a % b);
    }





    /*
    Same-colored scenario: The current post is painted the same as the previous one,
    which means the previous post must have been painted differently.
    Differently-colored scenario: The current post can be painted in any of the remaining k - 1 colors.
    This leads to the recur


     */
    int countWays(int n, int k) {
        if (n == 1) return k;        // Base case: 1 post can be painted in k ways
        if (n == 0) return 0;        // No posts, no ways to paint
        int same = 0;                // Initially no posts, so same is 0
        int different = k;           // First post can be painted in k ways
        int total = same + different; // Total ways for 1 post
        for (int i = 2; i <= n; i++) {
            same = different;            // Current post painted same as prev
            different = total * (k - 1); // Current post painted different
            total = same + different;    // Total ways for current post
        }
        return total;
    }


    public static int helper(List<Integer> list, int index, int[] dp) {
        if (index >= list.size()) return 0;
        if (dp[index] != -1) return dp[index];
        int take = list.get(index) + helper(list, index+1, dp);
        int no = helper(list, index+1, dp);
        int max = Math.max(take, no);
        dp[index] = max;
        return max;
    }
    public long findMaxProduct(List<Integer> arr) {
        int maxNegative = Integer.MIN_VALUE;
        int n = arr.size();
        long product = 1;
        int zeroCount = 0;
        int negCount = 0;
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            if (num < 0) {
                negCount++;
                maxNegative = Math.max(maxNegative, num);
            }
            product *= num;
        }
        if (zeroCount == n)
            return 0;

        if (negCount % 2 != 0)
            product /= maxNegative;
        return product;
    }



    //s1 = "babgbag", s2 = "bag" here there are 6 subsequences in different
    public static int distinctSubsequence(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        return countSub(map, s1, s2, s1.length(), s2.length());
    }
    private static int countSub(Map<String, Integer> map, String s1, String s2, int i, int j){
        if (j == 0) return 1;
        if (i == 0) return 0;
        String key = i +" "+j;
        if (map.containsKey(key))
            return map.get(key);
        int result;
        if (s1.charAt(i-1) == s2.charAt(j-1)){
            result = countSub(map, s1, s2, i-1, j-1) + countSub(map, s1, s2, i-1, j);
        }
        else {
            result = countSub(map, s1, s2, i-1, j);
        }

        map.put(key, result);
        return result;
    }

    //needs work
    public static int minimumNumberOfSwaps(String s) {
        List<Integer> list = new ArrayList<>();
        int balance = 0, index = 0, swaps = 0;
        int n = s.length();

        // Store indices of all '[' brackets
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') {
                list.add(i);
            }
        }

        // Process the string to check balance
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') {
                balance++;
                index++; // Move to the next '[' in list
            } else {
                balance--;
            }

            // If balance goes negative, we need a swap
            if (balance < 0) {
                swaps += list.get(index) - i;
                balance = 1; // Reset balance after swapping
            }
        }
        return swaps;
    }

    /*
    Input: s = "][]["
    Output: 1
    Explanation: You can make the string balanced by swapping index 0 with index 3.
    The resulting string is "[[]]".
     */
    public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) count++;
                else{
                    stack.pop();
                }
            }
        }
        if(count == 0) return 0;
        return (count+1) /2;
    }



    static int checkCompressed(String S, String T) {
        int n = S.length();
        int i = 0;
        int j = 0;
        int num = 0;
        int m = T.length();
        while (i < n && j < m){
            char c = T.charAt(j);
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            }

            else {
                i += num;
                num = 0;
                if (S.charAt(i) != T.charAt(j))
                    return 0;
                i++;
            }
            j++;
        }
        i += num;
        return j == m && i == n ? 1 : 0;
    }
    static String lookandsay(int n) {
        StringBuilder prev = new StringBuilder("1");
        int i = 1;
        while (i < n){
            StringBuilder current = new StringBuilder();
            int j = 0;
            int count = 1;
            int m = prev.length();
            while (j < m){
                if (j+1 < m && prev.charAt(j+1) == prev.charAt(j)){
                    count++;
                }
                else {
                    current.append(count);
                    current.append(prev.charAt(j));
                    count = 1;
                }
              j++;
            }
            prev = current;
            i++;
        }
        return prev.toString();
    }
    public String rearrange(String S, int N){
        List<Character> vowels = new ArrayList<>();
        List<Character> cons = new ArrayList<>();
        for (char c : S.toCharArray()){
            if (isVowel(c))
                vowels.add(c);
            else cons.add(c);
        }
        StringBuilder builder = new StringBuilder();
        int n = vowels.size();
        int m = cons.size();
        if (Math.abs(n - m) > 1) return "-1";
        Collections.sort(vowels);
        Collections.sort(cons);
        int i = 0;
        int j = 0;
        boolean startWithVowel;
        if (n > m) {
            startWithVowel = true;
        } else if (m > n) {
            startWithVowel = false;
        } else {
            startWithVowel = vowels.get(0) < cons.get(0);
        }
        while (i < n || j < m){
            if (startWithVowel && i < n){
                builder.append(vowels.get(i++));
            }
            if (!startWithVowel && j < m){
                builder.append(cons.get(j++));
            }
            startWithVowel = !startWithVowel;
        }
        return builder.toString();
    }
    private boolean isVowel(char c){
        return "aeiou".indexOf(c) != -1;
    }


    int isRepeat(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++){
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = lps[j-1];
            if (s.charAt(i) == s.charAt(j))
                j++;
            lps[i] = j;
        }
        int lengthOfPattern = n - lps[n-1];
        return lps[n-1] > 0 && n % lengthOfPattern == 0 ? 1 : 0;
    }

    public static boolean isFrequencyUnique(int n, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(n, 0)+1);
        HashSet<Integer> set = new HashSet<>();
        for (int num : map.values()){
            if (set.contains(num))
                return false;
            set.add(num);
        }
        return true;
    }


    /*
    This method counts the number of fraction pairs (num1/den1, num2/den2) such that their sum equals 1.
    How Complement Works
    The goal is to find two fractions that sum to 1.
    If we have a fraction num/den, the required complement is:
     */
    public static int countFractions(int n, int[] numerator, int[] denominator) {
       Map<String, Integer> map = new HashMap<>();
       int ans = 0;
       for (int i = 0; i < n; i++){
           int gcd = gcd(numerator[i], denominator[i]);
           int num = numerator[i] / gcd;
           int den = denominator[i] / gcd;
           int complement = den - num;
           String key = complement +"/" +den;
           if (map.containsKey(key))
               ans += map.get(key);
           String s = num +"/"+den;
           map.put(s, map.getOrDefault(s, 0)+1);
       }
       return ans;
    }


    //alternative approach
    public static ArrayList<Integer> getDistinct(int n, int[] arr){
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0)+1);
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)-1);
            if (freq.get(arr[i]) == 0)
                freq.remove(arr[i]);
            result.add(set.size() - freq.size());
            set.add(arr[i]);
        }
        return result;
    }


    public List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum))
                    map.put(sum, new ArrayList<>());
                map.get(sum).add(new int[]{i,j});
            }
        }

        for (int i = 0; i < n; i++){
            int rem = -arr[i];
            if (map.containsKey(rem)){
                List<int[]> a = map.get(rem);
                for (int[] p : a){
                    if (p[0] != i && p[1] != i)
                        list.add(new ArrayList<>(Arrays.asList(i,p[0],p[1])));
                }
            }
        }
        return list;
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int maxElement = arrays.get(0).get(arrays.get(0).size()-1);
        int minElement = arrays.get(0).get(0);
        int maxDifference = maxElement - minElement;
        for (int i = 1; i < n; i++){
            maxDifference = Math.max(maxDifference, Math.abs(maxElement - arrays.get(i).get(0)));
            maxDifference = Math.max(maxDifference, Math.abs(minElement - arrays.get(i).get(arrays.get(i).size()-1)));

            minElement = Math.min(minElement, arrays.get(i).get(0));
            maxElement = Math.max(maxElement, arrays.get(i).get(arrays.get(i).size()-1));
        }
        return maxDifference;
    }



    //INPUT : DDDIDIIII op => [3, 2, 1, 0, 5, 4, 6, 7, 8, 9]
    public static int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        for (int i = 0; i <= n; i++){
            if (i == n || s.charAt(i) == 'I'){
                result[i] = low++;

                while (!stack.isEmpty())
                    result[stack.pop()] = low++;
            }
            else stack.push(i);
        }

        return result;
    }



    public List<String> all_palindromes(String s){
        List<String> result = new ArrayList<>();
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        StringBuilder half = new StringBuilder();
        Character odd = null;
        for (int i = 0; i < 26; i++){
            if (freq[i] > 0){
                if (freq[i] % 2 != 0){
                    if (odd != null)
                        return result;
                    else odd = (char) (i + 'a');
                }
                half.append(String.valueOf((char) (i + 'a')).repeat(Math.max(0, freq[i] / 2)));
            }
        }
        List<String> permutations = new ArrayList<>();
        char[] arr = half.toString().toCharArray();
        Arrays.sort(arr);
        generatePalindrome(arr,new boolean[half.length()],new StringBuilder(), permutations);
        for (String per : permutations){
            StringBuilder current = new StringBuilder(per);
            if (odd != null){
                current.append(odd);
            }
            current.append(new StringBuilder(per).reverse());
            result.add(current.toString());
        }

        return result;
    }
    private static void generatePalindrome(char[] arr, boolean[] used, StringBuilder builder, List<String> list){
        if (builder.length() == arr.length){
            list.add(builder.toString());
            return;
        }

        for (int i = 0; i < used.length; i++){
            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;
            builder.append(arr[i]);
            used[i] = true;
            generatePalindrome(arr, used, builder, list);
            used[i] = false;
            builder.deleteCharAt(builder.length()-1);
        }
    }


    public static String nextPalin(String N){
        char[] arr = N.toCharArray();
        int len = arr.length;
        if (!isPalindrome(arr))
            return "-1";
        int mid = len/2;
        char[] first = Arrays.copyOfRange(arr,0,mid);

        if (!nextPalindrome(first))
            return "-1";

        StringBuilder builder = new StringBuilder(new String(first));
        if (len % 2 == 0)
            builder.append(arr[mid]);

        builder.append(new StringBuilder(new String(first)).reverse());
        return builder.toString();
    }




    private static boolean isPalindrome(char[] arr){
        int i = 0;
        int j = arr.length-1;
        while (i < j){
            if (arr[i] != arr[j])
                return false;
            i++;
            j--;
        }
        return true;
    }


    private static boolean nextPalindrome(char[] arr){
        int n = arr.length;
        int i = n-2;
        while (i >= 0 && arr[i] >= arr[i+1])
            i--;
        if (i == -1)
            return false;
        int j = n-1;
        while (j >=  0 && arr[i] >= arr[j])
            j--;
        swap(arr,i,j);

        reverse(arr, i+1, n-1);
        return true;
    }

    private static void reverse(char[] arr, int i, int j){
        while (i < j)
            swap(arr,i++,j--);
    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static int longestSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int num : arr){
            int length = 1 + Math.max(map.getOrDefault(num-1,0) , map.getOrDefault(num+1,0));
            map.put(num, length);
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int pos = binarySearch(dp, num);

            if (pos < dp.size())
                dp.set(pos, num);
            else
                dp.add(num);
        }
        System.out.println(dp);
        return dp.size();
    }

    private static int binarySearch(ArrayList<Integer> dp, int target) {
        int left = 0, right = dp.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dp.get(mid) >= target)
                right = mid - 1;
            else
                left = mid + 1;

        }
        return left;
    }


    // both are same the above and below program


    public static List<Integer> findLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] = length of LIS ending at index i
        int[] prevIndex = new int[n]; // To track previous elements in LIS

        Arrays.fill(dp, 1); // Every element is an LIS of length 1 by itself
        Arrays.fill(prevIndex, -1); // -1 means no previous element

        int maxLength = 1, lastIndex = 0; // Track max LIS length & last index

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prevIndex[i] = j; // Track previous element
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i; // Update last index of LIS
            }
        }

        // Reconstruct LIS using prevIndex array
        List<Integer> lis = new ArrayList<>();
        while (lastIndex != -1) {
            lis.add(nums[lastIndex]);
            lastIndex = prevIndex[lastIndex];
        }
        Collections.reverse(lis); // Reverse to get LIS in order
        return lis;
    }


    public static void main(String[] args) {
        System.out.println(maxSumSequence(16, new int[]{2,5,1,3,6,1,6,3,8,7,9,6,4,5,7,8,10}));
    }
    static List<Integer> maxSumSequence(int N, int A[]){
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[N];
        int[] prevIndex = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = A[i];
            prevIndex[i] = -1;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[j] + A[i] > dp[i]){
                    dp[i] = dp[j] + A[i];
                    prevIndex[i] = j;
                }
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < N; i++) {
            if (dp[i] > dp[maxIndex]){
                maxIndex = i;
            }
        }

        while (maxIndex != -1){
            list.add(A[maxIndex]);
            maxIndex = prevIndex[maxIndex];
        }

        Collections.reverse(list);
        return list;
    }

    public static int maxSum(int n){
        if (n <= 0)
            return 0;
        int max = 0;
        int one = n/2;
        int two = n/3;
        int three = n/4;
        max = one+ three + two;
        int[] arr = {one, two, three};
        for (int a : arr)
            max = Math.max(max, maxSum(a));
        return max;
    }
    static int zigzagSequence(int n, int[][] M){
        int[][] memo = new int[n][n];
        int ans = 0;
        for (int[] arr : memo)
            Arrays.fill(arr,-1);
        for (int i = 0; i < n; i++){
            ans = Math.max(ans, findSum(M,memo, 0,i));
        }
        return ans;
    }

    static int findSum(int[][] arr, int[][] memo, int i, int j){
        if (i == arr.length)
            return 0;
        if (j < 0 || j >= arr[0].length)
            return -1;
        if (memo[i][j] != -1)
            return memo[i][j];
        int left = arr[i][j] + findSum(arr, memo, i, j-1);
        int right = arr[i][j] + findSum(arr, memo, i, j+1);
        memo[i][j] = Math.max(left, right);
        return memo[i][j];
    }


}
