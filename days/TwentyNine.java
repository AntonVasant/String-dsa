package days;

import java.util.*;

public class TwentyNine {
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

    public int minimumTime(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int n = grid.length;
        int m = grid[0].length;
        int[][] times = new int[n][m];
        for (int[] arr : times)
            Arrays.fill(arr,Integer.MAX_VALUE);
        pq.offer(new int[]{0,0,0});
        while (!pq.isEmpty()){
                int[] current = pq.poll();
                int time = current[2];
                for (int[] arr : directions){
                    int x = arr[0] + current[0];
                    int y = arr[1] + current[1];
                    if (x == n-1 && y == m-1)
                        return current[2];
                   if (x < 0 || y < 0 || x >= n || y >= m)
                       continue;
                   int newTime = Math.max(time, grid[x][y]);
                   if (newTime < grid[x][y]){
                       System.out.println(newTime);
                       times[x][y] = newTime;
                       pq.offer(new int[]{x,y,newTime});
                   }
                }
        }
        return -1;
    }
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left+1])
            left++;
        if (left == n-1)
            return 0;
        int right = n-1;
        while (right > 0 && arr[right] >= arr[right-1])
            right--;

        int min = Math.min(n - left-1,right);
        int i = 0;
        int j = right;
        while (i < left && j < n){
            if (arr[i] <= arr[j]){
                min = Math.min(min, j - i -1);
                i++;
            }
            else j++;
        }
        return min;
    }
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int second = Integer.MIN_VALUE;
        for (int i = n-1; i >= 0; i--){
            if (nums[i] < second)
                return true;
            while (!stack.isEmpty() && nums[i] < stack.peek())
                second = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr)
            if (!stack.isEmpty() && num < stack.peek()){
                int larger = stack.pop();
                while (!stack.isEmpty() && num < stack.peek())
                    stack.pop();
                stack.push(larger);
            }
            else stack.push(num);
        return stack.size();
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i])/speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(b[0] , a[0]));
        int fleet = 0;
        double last = 0;
        for (int i = 0; i < n; i++){
            double currentCar = cars[i][1];
            if (currentCar > last){
                fleet++;
                last = currentCar;
            }
        }
        return fleet;
    }
    public int maxWidthRamp(int[] nums) {
        int min = nums[0];
        int n = nums.length;
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n && j < n){
            if (nums[i] >= min){
                ans = Math.max(ans, i - j);
                System.out.println(i +" "+j);
                i++;
            }
            else {
                j++;
                if (j < n)
                    min = Math.min(min, nums[j]);
            }
        }
        return ans;
    }
    public int longestWPI(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if (hours[i] > 8)
                prefix++;
            else prefix--;
            if (map.containsKey(prefix-1))
                max = Math.max(max, i - map.get(prefix-1));

            map.putIfAbsent(prefix, i);
        }
        return max;
    }
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i])
                prices[stack.peek()] = prices[stack.pop()] - prices[i];
            stack.push(i);
        }
        return prices;
    }
    public int numSubmat(int[][] mat) {
        int m = mat[0].length;
        int count = 0;
        int[] ar = new int[m];
        for (int[] arr : mat) {
            for (int j = 0; j < m; j++) {
                ar[j] = arr[j] == 0 ? 0 : ar[j] + 1;
            }
            count += calculateNumberOfMatrix(ar);
        }
        return count;
    }
    private int calculateNumberOfMatrix(int[] height){
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int n = height.length;
        for (int i = 0; i <= n; i++){
            int h = i == n ? 0 : height[i];
            while (!stack.isEmpty() && h < height[stack.peek()]){
                int tall = height[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek();
                area += (tall * (tall+1)) / 2*width;
            }
            stack.push(i);
        }
        return area;
    }

    public int reverseExponentiation(int n) {
        int reverse = reverseNum(n);
        return powerOfNumber(n, reverse);
    }
    private int powerOfNumber(int base, int exponent){
        if (exponent == 0)
            return 1;
        if (exponent %  2 == 0){
            int half = powerOfNumber(base, exponent/2);
            return half * half;
        }
        else return base * powerOfNumber(base,exponent-1);
    }
    private int reverseNum(int n){
        int ans = 0;
        while (n > 0){
            int digit = n % 10;
            ans = 10 * ans +digit;
            n /= 10;
        }
        return ans;
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        subsetSum(list,arr,0,0);
        Collections.sort(list);
        return list;
    }
    private void subsetSum(ArrayList<Integer> list, int[] arr,int index,int sum){

        if (index == arr.length){
            list.add(sum);
            return;
        }
        subsetSum(list, arr, index+1, sum);
        subsetSum(list,arr,index+1,sum+arr[index]);

    }
    static int maximumAmount(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        return money(arr,0,n-1,dp);
    }
    private static int money(int[] arr, int left, int right,int[][] dp) {
        if (left > right || left >= arr.length || right < 0)
            return 0;
        if (dp[left][right] != 0)
            return dp[left][right];
        int pickLeft = arr[left] + Math.min(money(arr, left + 2, right,dp), money(arr, left + 1, right - 1,dp));
        int pickRight = arr[right] + Math.min(money(arr, left + 1, right - 1,dp), money(arr, left, right - 2,dp));
        return dp[left][right] =  Math.max(pickLeft, pickRight);
    }
    public String[] wordBoggle(char board[][], String[] dictionary){
        int n = board.length;
        int m = board[0].length;
        List<String> list = new ArrayList<>();
        for (String s : dictionary)
            for (int i = 0; i < n; i++){
                boolean found = false;
                for (int j = 0; j < m; j++)
                    if (board[i][j] == s.charAt(0)){
                        if (findWord(0,board,s,i,j)){
                            list.add(s);
                            found = true;
                            break;
                        }
                    }

                if (found)
                    break;
            }

        String[] ans = new String[list.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = list.get(i);

        return ans;
    }
    private boolean findWord(int index, char[][] board, String s, int i, int j){
        if (index == s.length())
            return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != s.charAt(index))
            return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        for (int[] dir : directions){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (findWord(index+1,board,s,x,y)) {
                board[i][j] = temp;
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
    public int[][] searchWord(char[][] grid, String word){
        List<List<Integer>> list = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == word.charAt(0)){
                    for (int[] dir : directions){
                        if (findWord(grid,word,0,i,j,dir))
                            list.add(new ArrayList<>(Arrays.asList(i,j)));
                    }
                }
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
    private boolean findWord(char[][] board, String s, int index,int i, int j,int[] dir){
        if (index == s.length())
            return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != s.charAt(index))
            return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean ans = findWord(board,s,index+1,i+dir[0],j+dir[1],dir);
        board[i][j] = temp;
        return ans;
    }
    long numberOfPath(int n, int k, int [][]arr) {
        int m = arr[0].length;
        return paths(arr,0,0,k,n,m);
    }
    private long paths(int[][] arr, int i, int j, int k,int n,int m){
        if (i == n-1 && j == m-1)
            return k - arr[i][j] == 0 ? 1 : 0;
        if (i == arr.length || j == arr[0].length || k < 0)
            return 0;
        long one = paths(arr,i+1,j,k - arr[i][j],n,m);
        long two = paths(arr,i,j+1,k - arr[i][j],n,m);
        return one + two;
    }
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> list = new ArrayList<>();
        generateBinary(list,"",0,0,N);
        return list;
    }
    private void generateBinary(ArrayList<String> list, String s, int ones, int zeros,int n){
        if (s.length() == n){
            list.add(s);
            return;
        }
        generateBinary(list, s+"1", ones+1, zeros, n);
        if (ones > zeros)
            generateBinary(list, s+"0", ones, zeros+1, n);
    }
    public static void main(String[] args) {
        TwentyNine nine = new TwentyNine();
        nine.findLengthOfShortestSubarray(new int[]{1,2,3,7,6,4,7,8,9});
    }
}
