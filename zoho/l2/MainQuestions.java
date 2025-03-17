package zoho.l2;

import java.util.*;

public class MainQuestions {
    static int findNumberOfTriangles(int[] arr, int n) {
        int count = 0;
        Arrays.sort(arr);
        for (int c = n - 1; c >= 2; c--) {
            int i = 0;
            int j = c - 1;
            while (i < j) {
                if (arr[i] + arr[j] > arr[c]) {
                    count += j - i + 1;
                    j--;
                } else i++;
            }
        }
        return count;
    }

    long countSubstring(String S) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        int balance = 0;
        for (char c : S.toCharArray()) {
            balance += (c == '1') ? 1 : -1;
            if (balance > 0)
                ans += map.values().stream().mapToInt(Integer::intValue).sum();
            else ans += map.getOrDefault(balance - 1, 0);
            map.put(balance, map.getOrDefault(balance, 0));
        }
        return ans;
    }

    public static int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the table
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][n - 1];
    }
    public static int minSwap(int[] arr, int n, int k) {
        int count = 0;
        for (int num : arr) {
            if (num <= k)
                count++;
        }
        int wrong = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > k)
                wrong++;
        }

        int minSwaps = 0;
        for (int i = count; i < n; i++) {
            if (arr[i - count] > k)
                wrong--;
            if (arr[i] > k)
                wrong++;
            minSwaps = Math.max(minSwaps, wrong);
        }
        return minSwaps;
    }
    public boolean canPair(List<Integer> arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            int remainder = ((n % k) + k) % k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        for (int number : map.keySet()) {
            if (number == 0) {
                if (map.get(number) % 2 != 0) return false;
            } else {
                int complement = (k - number) % k;
                if (!map.containsKey(complement) || map.get(number) != map.get(complement))
                    return false;
            }
        }
        return true;
    }

    long findSwapValues(long[] a, int n, long[] b, int m) {
        long sum_a = 0, sum_b = 0;
        for (long num : a) sum_a += num;
        for (long num : b) sum_b += num;

        long delta = (sum_a - sum_b) / 2;

        // If the difference is odd, there is no solution
        if ((sum_a - sum_b) % 2 != 0) {
            return -1;
        }

        // Store elements of array b in a set for efficient lookup
        HashSet<Long> setB = new HashSet<>();
        for (long num : b) {
            setB.add(num);
        }

        for (long numA : a) {
            if (setB.contains(numA - delta))
                return 1;  // Found a valid pair

        }
        return -1;
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int top = s.pop();
            sort(s);
            sortStack(s, top);
        }
        return s;
    }

    private void sortStack(Stack<Integer> stack, int k) {
        if (stack.isEmpty() || stack.peek() <= k)
            stack.push(k);
        else {
            int temp = stack.pop();
            sortStack(stack, k);
            stack.push(temp);
        }
    }

    static int maxGold(int n, int m, int[][] M) {
        int ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, findGold(M, i, 0, n, m, dp));
        return ans;
    }

    private static int findGold(int[][] mine, int i, int j, int n, int m, int[][] dp) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int one = mine[i][j] + findGold(mine, i, j + 1, n, m, dp);
        int two = mine[i][j] + findGold(mine, i - 1, j + 1, n, m, dp);
        int three = mine[i][j] + findGold(mine, i + 1, j + 1, n, m, dp);
        return dp[i][j] = Math.max(one, Math.max(two, three));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        image(image, sr, sc, newColor, n, m);
        return image;
    }

    private void image(int[][] image, int i, int j, int color, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || image[i][j] == color)
            return;
        image[i][j] = color;
        image(image, i + 1, j, color, n, m);
        image(image, i - 1, j, color, n, m);
        image(image, i, j + 1, color, n, m);
        image(image, i, j - 1, color, n, m);
    }

    public static boolean isLucky(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        int round = 2;
        while (round <= list.size()) {
            for (int i = round - 1; i < list.size(); i += round) {
                list.set(i, null);
            }

            list.removeIf(Objects::isNull);
            round++;
        }
        return list.contains(n);
    }

    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
        int[] moveX = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] moveY = {1, -1, -2, 2, -2, 2, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{KnightPos[0], KnightPos[1]});
        boolean[][] visit = new boolean[N + 1][N + 1];
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                if (current[0] == TargetPos[0] && current[1] == TargetPos[1]) return step;
                for (int j = 0; j < 8; j++) {
                    int newX = current[0] + moveX[j];
                    int newY = current[1] + moveY[j];

                    if (newX >= 0 && newY >= 0 && newY < N && newX < N && !visit[newX][newY]) {
                        visit[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            step++;
        }
        return -1;
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        helper(list,A,new ArrayList<>(),B,0);
        System.out.println(list);
        return list;
    }

    private static void helper(ArrayList<ArrayList<Integer>> list,
                               ArrayList<Integer> array,
                               ArrayList<Integer> current,
                               int sum,int index){
        if (sum == 0) {
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < array.size(); i++) {
            if (i > index && array.get(i).equals(array.get(i - 1))) continue;
            if (array.get(i) > sum) break;
            current.add(array.get(i));
            helper(list, array, current, sum - array.get(i), i);
            current.remove(current.size() - 1); // Backtrack
        }
    }

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        if (n == 1) return new ArrayList<>(List.of(1));
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++){
           list = new ArrayList<>();
           list.add(1);
           for (int j = 1; j < i; j++){
               list.add(prev.get(j-1)+ prev.get(j));
           }
           list.add(1);
           prev = list;
        }
        return list;
    }

    public int[] twoRepeated(int n, int[] arr) {
        int[] ans = new int[2];
        for (int i = 0; i < n + 2; i++){
            while (arr[i] != arr[arr[i]-1]){
                int index = arr[i] - 1;
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        int j = 0;
        for (int i = 0; i < n + 2; i++){
            if (arr[i] != i+1)
                ans[j++] = arr[i];
        }
        return ans;
    }

    long countStrings(int n) {
        long MOD = 1000000007;
        if (n == 1) return 2;
        if (n == 2) return 3;

        long prev2 = 2;
        long prev1 = 3;
        for (int i = 3; i <= n; i++){
            long current = (prev1+prev2) %MOD;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    static int maxSquare(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int max = 0;
        int[][] dp = new int[row][col];
        for (int[] arr :dp)
            Arrays.fill(arr, -1);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (mat[i][j] == 1)
                    max = Math.max(max, findSquare(mat, i, j, dp));
            }
        }
        return max;
    }

    private static int findSquare(int[][] grid, int i, int j,int[][] memo){
        if (i < 0 || j < 0 || grid[i][j] == 0)
            return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int up = findSquare(grid, i-1, j, memo);
        int left = findSquare(grid, i, j-1, memo);
        int diagonal = findSquare(grid, i-1, j-1, memo);

        return memo[i][j] = Math.min(up,Math.min(diagonal, left)) + 1;
    }

    int findMaxSum(int[] arr, int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return findMaxSub(arr, 0 ,dp);
    }

    private int findMaxSub(int[] arr,int index,int[] dp){
        if (index >= arr.length) return 0;

        if (dp[index] != -1) return dp[index];
        int take = arr[index] + findMaxSub(arr,index + 2, dp);
        int no = findMaxSub(arr,index+1,dp);

        return dp[index] = Math.max(take, no);
    }

    static char[][] fill(int n, int m, char[][] a){
        int row = a.length;
        int col = a[0].length;
        for (int i = 0; i < row; i++){
            if (a[i][0] == 'O')
                markO(a, i, 0, row, col);
            else if (a[i][col-1] == 'O')
                markO(a, i, col-1, row, col);
        }

        for (int i = 0; i < col; i++){
            if (a[0][i] == 'O')
                markO(a,0,i,row,col);
            else if (a[row-1][i] == 'O')
                markO(a, row-1,i,row,col);
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (a[i][j] == 'O')
                    a[i][j] = 'X';
                else if (a[i][j] == 'S') {
                    a[i][j] = 'O';
                }
            }
        }
        return a;
    }

    private static void markO(char[][] grid, int i, int j, int n, int m){
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 'O')
            return;
        grid[i][j] = 'S';

        markO(grid, i+1, j, n, m);
        markO(grid, i-1, j, n, m);
        markO(grid, i, j+1, n, m);
        markO(grid, i, j-1, n, m);
    }
    static int maximumPath(int N, int[][] Matrix){
        int row = Matrix.length;
        int col = Matrix[0].length;
        int max = 0;
        int[][] dp = new int[row+1][col+1];
        for (int[] arr : dp)
            Arrays.fill(arr,-1);
        for (int i = 0; i < col; i++)
            max = Math.max(max, maximumPath(Matrix, 0, i,row, col,dp));
        return max;
    }
    private static int maximumPath(int[][] matrix, int i, int j, int n, int m,int[][] dp){
        if (i >= n || j >= m || j < 0)
            return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int down = maximumPath(matrix,i+1,j,n,m,dp);
        int one = maximumPath(matrix,i+1,j+1,n,m,dp);
        int two = maximumPath(matrix,i+1,j-1,n,m,dp);

        return dp[i][j] = Math.max(down, Math.max(one, two)) + matrix[i][j];
    }
    static long largestPrimeFactor(int N) {
        int prime = N;
        while (N % 2 == 0){
            prime = 2;
            N /= 2;
        }

        for (int i = 3; i *i <= N; i+=2){
            while (N % i == 0){
                prime = i;
                N/= i;
            }
        }
        if (N > 2)
            prime = N;
        return prime;
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < arr.length; i++){
            pq.offer(new int[]{arr[i][0],i,0});
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()){
            int[] current = pq.poll();
            list.add(current[0]);
            int next = current[2]+1;
            if (arr[current[1]].length > next){
               int element = arr[current[1]][next];
               pq.offer(new int[]{element, current[1],next});
            }
        }
        return list;
    }
    public static int LongestBitonicSequence(int n, int[] nums) {
        int[] LDS = findLDS(nums);
        int[] LIS = findLIS(nums);
        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, LIS[i] + LDS[i] - 1);
        }
        return max;
    }
    public static int[] findLIS(int[] arr){
        int n = arr.length;
        ArrayList<Integer> temp = new ArrayList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            int index = binarySearch(temp, arr[i]);
            if (index == temp.size())
                temp.add(arr[i]);
            else temp.set(index, arr[i]);
            ans[i] = index+1;
        }
        return ans;
    }
    private static int[] findLDS(int[] arr){
        int n = arr.length;
        int[] reverse = new int[n];
        for (int i = 0; i < n; i++)
            reverse[i] = arr[n-1-i];
        int[] LDS = findLIS(reverse);
        for (int i = 0; i < n; i++)
            reverse[i] = LDS[n-1-i];
        return reverse;
    }
    public static int binarySearch(ArrayList<Integer> list, int number){
        int low = 0;
        int high = list.size()-1;
        while (low <= high){
            int mid = (low + high) /2;
            if (list.get(mid) < number)
                low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    int longSubarrWthSumDivByK(int[] a, int k) {
        int max = 0;
        int n = a.length;
        int currentSum = 0;
        Map<Integer, Integer> map =  new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < n; i++){
            currentSum += a[i];

            int mod = ((currentSum%k) +k)%k;
            if (map.containsKey(mod))
                max = Math.max(max, i - map.get(mod));
            else map.put(mod, i);
        }
        return max;
    }

}
