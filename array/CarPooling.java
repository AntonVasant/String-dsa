package array;

import LLD.tollcollecting.TollA;

import javax.swing.event.ListDataEvent;
import java.util.*;

public class CarPooling {

    /*
    here is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi]
indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are
fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

     */
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        int current = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int[] trip : trips) {
            int start = trip[1];
            current += trip[0];
            while (!pq.isEmpty() && pq.peek()[2] <= start) {
                current -= pq.poll()[0];
            }
            if (current > capacity) return false;
            pq.offer(trip);
        }
        return true;
    }


    public static List<List<Integer>> splitArrayToMinimizeDifference(int[] arr) {
        int n = arr.length;
        int totalSum = Arrays.stream(arr).sum();

        int target = totalSum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        for (boolean[] ar : dp) {
            System.out.println(Arrays.toString(ar));
        }
        int closestSum = 0;
        for (int j = target; j >= 0; j--) {
            if (dp[n][j]) {
                closestSum = j;
                break;
            }
        }
        System.out.println(closestSum);
        List<Integer> subset1 = new ArrayList<>();
        List<Integer> subset2 = new ArrayList<>();
        int w = closestSum;

        for (int i = n; i > 0; i--) {
            if (dp[i - 1][w])
                subset2.add(arr[i - 1]);

            else {
                subset1.add(arr[i - 1]);
                w -= arr[i - 1];
            }
        }
        System.out.println(subset1);
        System.out.println(subset2);
        List<List<Integer>> result = new ArrayList<>();
        result.add(subset1);
        result.add(subset2);
        return result;
    }

    public int minNumber(int[] arr, int N) {
        int sum = Arrays.stream(arr).sum();
        for (int i = sum + 1; ; i++) {
            if (isPrime(i))
                return i;
        }
    }

    public boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2)
            return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }
        return true;
    }


    private ArrayList<Integer> getLongestIncreasingSequence(int[] arr, int[][] dp) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i][prev + 1] == 1 + dp[i + 1][i + 1]) {
                list.add(arr[i]);
                prev = i;
            }
        }
        return list;
    }

    class Pair{
        int firstOcc;
        int secondOcc;
        Pair(int firstOcc, int secondOcc ){
            this.firstOcc=firstOcc;
            this.secondOcc=secondOcc;
        }
    }

    public int countPalindromicSubsequence(String s) {
        Pair arr[] = new Pair[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new Pair(-1,-1);
        }
        for(int i=0;i<s.length();i++) {
            if (arr[s.charAt(i) - 'a'].firstOcc == -1) {
                arr[s.charAt(i) - 'a'].firstOcc = i;
            } else
                arr[s.charAt(i) - 'a'].secondOcc = i;
        }
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].firstOcc != -1 && arr[i].secondOcc !=-1){
                HashSet<Character> hs= new HashSet<>();
                for(int j=arr[i].firstOcc+1;j<arr[i].secondOcc;j++){
                    hs.add(s.charAt(j));
                }
                cnt += hs.size();
            }
        }
        return cnt;
    }
    public  int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && n - i - 1 + stack.size() >= k && stack.peek() > nums[i])
                stack.pop();
            stack.push(nums[i]);
        }


        while (stack.size() > k)stack.pop();
        int[] result = new int[k];
        int index = 0;
        for (int num : stack)
            result[index++] = num;
        return result;
    }
    public  int maximumScore(int[] nums, int k) {
        int left = k;
        int right = k;
        int min = nums[k];
        int n = nums.length;
        int score = 0;
        while (left > 0 || right < n - 1) {
            if (left == 0)
                right++;
            else if (right >= n - 1)
                left--;
            else if (nums[left - 1] < nums[right + 1])
                right++;
            else left--;
            min = Math.min(min, Math.min(nums[left], nums[right]));
            score = Math.max(score, min * (right - left + 1));
        }
        return score;
    }
    static int maxSumMinProduct(int[] n) {
        Stack<Integer> st = new Stack<>();
        long[] dp = new long[n.length + 1];
         long res = 0;
         for (int i = 0; i < n.length; ++i)
            dp[i + 1] = dp[i] + n[i];
        for (int i = 0; i <= n.length; ++i) {
            while (!st.empty() && (i == n.length || n[st.peek()] > n[i])) {
                int j = st.pop();
                res = Math.max(res, (dp[i] - dp[st.empty() ? 0 : st.peek() + 1]) * n[j]);
            }
            st.push(i);
        }
        return (int)(res % 1000000007);
    }

    /*
    Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest
     Fibonacci-like subsequence of arr. If one does not exist, return 0.
    A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr,
    without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].
     */

    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int res = 0;
        for (int i = 0; i  < n; i ++) {
            map.put(arr[i], i);
        }

        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        for (int i = 1; i < n;  i ++ ){
            for (int j = 0; j < i; j++) {

                int prev = arr[i] - arr[j];
                if (map.containsKey(prev) && map.get(prev) < j) {
                    dp.putIfAbsent(j, new HashMap<>());

                    dp.get(j).put(i, dp.getOrDefault(map.get(prev), new HashMap<>()).getOrDefault(j,0)+1);
                    res = Math.max(res, dp.get(j).get(i));
                }
            }
        }

        return res == 0 ? 0 : res + 2;
    }


    /*
    you have n  tiles, where each tile has one letter tiles[i] printed on it.
Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
Example 1:
Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
     */
    public int numTilePossibilities(String tiles) {

        char[] arr = tiles.toCharArray();
        return numberOfPermutation(arr, 0);
    }

    private int numberOfPermutation(char[] arr, int start){
        if (start == arr.length) return 0;
        int ans = 0;
        for (int i = start; i < arr.length; i++) {
            if (!isPermutation(arr,start, i -1, arr[i])){
                swap(arr, start, i);
                ans += 1 + numberOfPermutation(arr, start+1);
                swap(arr, start, i);
            }
        }

        return ans;
    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isPermutation(char[] arr, int i, int j, char letter) {
        while (i <= j) {
            if (arr[i++] == letter) return true;
        }
        return false;
    }

    /*
    ou can choose any number of columns in the matrix and flip every cell in that column
     (i.e., Change the value of the cell from 0 to 1 or vice versa).
Return the maximum number of rows that have all values equal after some number of flips.
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int m = matrix[0].length;
        for (int[] arr : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++)
                sb.append(arr[0] == arr[i]  ? '1' : '0');
            String res = sb.toString();
            map.put(res, map.getOrDefault(res, 0)  + 1);
        }

        int ans = 0;
        for (int num : map.values()) ans = Math.max(ans, num);
        return ans;
    }

    /*
    You are given n item's value and label as two integer arrays values and labels.
    You are also given two integers numWanted and useLimit
Your task is to find a subset of items with the maximum sum of their values such that:
The number of items is at most numWanted.
The number of items with the same label is at most useLimit.
Return the maximum sum.
Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
Output: 9
Explanation:
The subset chosen is the first, third, and fifth items with the sum of values 5 + 3 + 1.
     */
    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for (int i = 0; i < values.length; i++){
            pq.add(new int[]{values[i], labels[i]});
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        while (numWanted > 0 && !pq.isEmpty()){
            int[] current = pq.poll();
            if (map.getOrDefault(current[1], 0) <= useLimit){
                ans += current[0];
                numWanted--;
                map.put(current[1], map.getOrDefault(current[1], 0) + 1);
            }
        }
        return ans;
    }

    //leetcode 1138
    public static String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        int currentX = 0;
        int currentY = 0;
        for (char c : target.toCharArray()) {
            int targetX = (c - 'a') / 5;
            int targetY = (c - 'a') % 5;
            if (c == 'z'){
                while (currentY > targetY){
                    ans.append("L");
                    currentY--;
                }

                while (currentX < targetX){
                    ans.append("D");
                    currentX++;
                }
            }
            else {

                while (currentX < targetX){
                    ans.append("D");
                    currentX++;
                }
                while (currentX > targetX){
                    ans.append("U");
                    currentX--;
                }

                while (currentY < targetY){
                    ans.append("R");
                    currentY++;
                }

                while (currentY > targetY){
                    ans.append("L");
                    currentY--;
                }
            }
            ans.append("!");
        }

        return ans.toString();
    }

    public int maxRepOpt1(String text) {
        int[] arr = new int [26];
        for(int a=0;a<text.length();a++){
            arr[text.charAt(a)-'a']++;
        }
        int i = 0;
        int len = 0;
        int n = text.length();
        while(i < n){
            int j = i;
            while(j<n&&text.charAt(j)==text.charAt(i)){
                ++j;
            }
            int block1 = j-i;
            int k = j+1;
            while(k<n&&text.charAt(k)==text.charAt(i)){
                ++k;
            }
            int block2 = k-j-1;
            len = Math.max(len,Math.min(block1+block2+1,arr[text.charAt(i)-'a']));
            i=j;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(alphabetBoardPath("code"));
    }

}
