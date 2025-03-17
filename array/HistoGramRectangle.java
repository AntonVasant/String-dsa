package array;

import java.util.*;

public class HistoGramRectangle {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int index = 0;
        while (index < heights.length){
            if(stack.isEmpty() || heights[index] >= heights[stack.peek()]){
                stack.push(index++);
            }else{
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? index : index - stack.peek()-1;
                max = Math.max(max,height * width);
            }
        }

        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? index : index - stack.peek()-1;
            max = Math.max(max,height * width);
        }
        return max;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
    public long minCost(long[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long n : arr)
            pq.offer(n);
        long ans = 0;
        while (pq.size() > 1){
            long one = pq.poll();
            long two = pq.poll();
            ans += one+two;
            pq.offer(one+two);
        }

        return ans;
    }
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        int n = arr.size();
        for (int i = 0; i + m < n; i++){
            int diff = arr.get(i + m) - arr.get(i);
            min = Math.min(min,diff);
        }
        return min;
    }
    public static String smallestWindow(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s2.toCharArray())
            map.put(c,map.getOrDefault(c, 0)+1);
        Map<Character, Integer> currentMap = new HashMap<>();
        int found = 0;
        int needed = map.size();
        int min = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        int n = s1.length();
        for (int right = 0; right < n; right++){
            char rightChar = s1.charAt(right);
            currentMap.put(rightChar, currentMap.getOrDefault(rightChar, 0)+1);
            if (map.containsKey(rightChar) && currentMap.get(rightChar).intValue() == map.get(rightChar).intValue())
                found++;
            while (left <= right && found == needed){
                if (right - left < min){
                    min = right - left;
                    start = left;
                }
                char leftChar = s1.charAt(left);
                currentMap.put(leftChar, currentMap.getOrDefault(leftChar, 0)-1);
                if (map.containsKey(leftChar) && map.get(leftChar) > currentMap.get(leftChar))
                    found--;
                left++;
            }
        }

        return min == Integer.MAX_VALUE ?  "" : s1.substring(start, start + min+1);
    }
    String colName (long n){
        StringBuilder ans = new StringBuilder();
        while (n > 0){
            n--;
            int rem = (int) (n % 26);
            char c = (char) ('A' + rem);
            ans.append(c);
            n /= 26;
        }
        return ans.toString();
    }


    public int wildCard(String pattern, String str) {
        int n = pattern.length();
        int m = str.length();
        Boolean[][] dp = new Boolean[n][m];
        boolean ans  =  checkWildCard(pattern,str,0,0,dp);
        return ans ? 1 : 0;
    }

    private boolean checkWildCard(String pattern, String s, int index1, int index2,Boolean[][] dp){
        if (index1 == pattern.length()) return index2 == s.length();
        if (index2 == s.length()){
            for (int i = index1; i < pattern.length(); i++){
                if (pattern.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        if (dp[index1][index2] != null) return dp[index1][index2];

        if (pattern.charAt(index1) == s.charAt(index2) || pattern.charAt(index1) == '?')
            return checkWildCard(pattern, s, index1+1, index2+1, dp);

        boolean first = false;

        if (pattern.charAt(index1) == '*')
            first = checkWildCard(pattern, s, index1, index2+1, dp) ||
                    checkWildCard(pattern, s, index1+1, index2, dp);

        dp[index1][index2] = first;

        return first;
    }

    public static String betterString(String str1, String str2) {
        int one = countDistinctSubsequence(str1);
        int two = countDistinctSubsequence(str2);

        return one >= two ? str1 : str2;
    }

    private static int countDistinctSubsequence(String s){
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            dp[i+1] = 2 * dp[i];
            if (map.containsKey(s.charAt(i)))
                dp[i + 1] -= dp[map.get(s.charAt(i))];

            map.put(s.charAt(i),i);
        }
        return dp[n]- 1;
    }


    private static final int MOD = 1_000_000_007;
    public static long sumSubstrings(String s){
        int n = s.length();
        long[] dp = new long[n];
        dp[0] = s.charAt(0) - '0';
        long sum = dp[0];
        for (int i = 1; i < n; i++){
            int digit = s.charAt(i) - '0';
            dp[i] = ((dp[i - 1] * 10) + (long) digit * (i + 1)) % MOD;
            sum = (sum + dp[i])% MOD;
        }
        return sum;
    }


    int countRev (String s){
        int n = s.length();
        if (n %2 != 0) return -1;
        int open = 0;
        int close = 0;
        for (char c : s.toCharArray()){
            if (c == '{')
                open++;
            else {
                if (open > 0)
                    open--;
                else close++;
            }
        }
        return (open)/2+ (close)/2;
    }
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
      Map<String, ArrayList<String>> map = new LinkedHashMap<>();
      for (String s : arr){
          int[] freq = new int[26];
          for (char c : s.toCharArray())
              freq[c - 'a']++;
          StringBuilder builder = new StringBuilder();
          for (int n : freq)
              builder.append(n).append("#");
          String key  = builder.toString();
          map.computeIfAbsent(key, k-> new ArrayList<>()).add(s);
      }

        return new ArrayList<>(map.values());
    }
    /*

    friend problem
     */
    private static long countWaysMemo(int N,Map<Integer,Long> memo) {
        if (N == 0) return 1;
        if (N == 1) return 1;
        if (memo.containsKey(N))
            return memo.get(N);

        long result = (countWaysMemo(N - 1,memo) + (N - 1) * countWaysMemo(N - 2,memo)) % MOD;
        memo.put(N, result);
        return result;
    }


    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int steps = 1;
        queue.offer(start);
        Set<Integer> set = new HashSet<>();
        set.add(steps);
        while (!queue.isEmpty()){
           int size = queue.size();
           for (int i = 0; i < size; i++){
               int current = queue.poll();
               for (int n : arr){
                   int number = current * n;
                   if (number == end) return steps;
                   if (!set.contains(number)){
                       queue.offer(number);
                       set.add(number);
                   }
               }
           }
           steps++;
        }
        return -1;
    }
    int median(final int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int totalElements = (row * col);
        int medianPos = (totalElements+ 1)/2;
        int low = matrix[0][0];
        int high = matrix[row-1][col-1];
        while (low < high){
            int mid = (low + high)/2;
            int count = countLessNumbers(matrix,mid);
            if (count < medianPos)
                low = mid + 1;
            else high = mid;
        }
        return low;
    }
    private int countLessNumbers(int[][] matrix, int num){
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col-1;
        int count = 0;
        while (i < row && j >= 0){
            if (matrix[i][j] < num){
                count += j + 1;
                i++;
            }
            else j--;
        }
        return count;
    }
    public long countPairs(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int n : arr){
            if (n > 1)
                list.add(n);
        }
        long num = list.size();
        return (num * (num - 1))/2;
    }


    public static void printLongestIncreasing(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int[] map = new int[n];
        Arrays.fill(map, -1);
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                    map[i] = j;
                }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++){
            if (max < dp[i]){
                max = dp[i];
                index = i;
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(map));
        List<Integer> list = new ArrayList<>();
        while (index != -1){
            list.add(arr[index]);
            index = map[index];
        }
        System.out.println(list);
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        helper(dp, text1, text2, n, m);
        StringBuilder builder = new StringBuilder();
        int i = n;
        int j = m;
        while (i > 0 && j > 0){
            if (dp[i][j] > dp[i-1][j] && dp[i][j] >  dp[i][j-1]){
                builder.append(text1.charAt(i-1));
            }

            if (dp[i-1][j] > dp[i][j-1]) i--;
            else if (dp[i][j-1] > dp[i-1][j])j--;
            else {
                i--;
                j--;
            }
        }
        builder.reverse();
        System.out.println(builder);
        return 0;
    }


    private void helper(int[][] dp, String s1, String s2, int n, int m){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt( j - 1)){
                    dp[i][j] = 1  + dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        for (int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
    }




}
