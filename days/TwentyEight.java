package days;

import linkedList.ListNode;

import java.util.*;
import java.util.function.IntToDoubleFunction;

public class TwentyEight {

    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] min = new int[n][m];
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for (int[] arr : min)
            Arrays.fill(arr,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,0,0});
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int value = cur[0];
            int x = cur[1];
            int y = cur[2];
            if (x == n-1 && y == m-1)
                return value + grid[n-1][m-1];
            for (int[] a : dir){
                int xn = x + a[0];
                int yn = y + a[1];
                if (xn >= 0 && xn < n && yn >= 0 && yn < m){
                    int cost = value + grid[xn][yn];
                    if (cost < min[xn][yn]){
                        pq.offer(new int[]{cost,xn, yn});
                        min[xn][yn]  = cost;
                    }
                }
            }
        }
        return -1;
    }
    public String compressedString(String word) {
        StringBuilder builder  = new StringBuilder();
        int count = 1;
        int n = word.length();
        for (int i = 1; i < n; i++){
            char c = word.charAt(i);
            if (c != word.charAt(i-1) || count == 9){
                builder.append(count);
                builder.append(word.charAt(i-1));
                count = 0;
            }
            count++;
        }
        if (word.charAt(n-1) == word.charAt(n-2))
            builder.append(count).append(word.charAt(n-1));
        return builder.toString();
    }
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = findLIS(nums);
        reverse(nums);
        int[] lds = findLIS(nums);
        System.out.println(Arrays.toString(lds));
        System.out.println(Arrays.toString(lis));
        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, lis[i] + lds[i] -1);
        }
        return n - max;
    }
    private void reverse(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    private int[] findLIS(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int pos = binarySearch(list, arr[i]);
            if (pos >= list.size())
                list.add(arr[i]);
            else list.set(pos, arr[i]);
            ans[i] = pos+1;
        }
        return ans;
    }
    private int binarySearch(List<Integer> list, int target){
        int low = 0;
        int high = list.size()-1;
        while (low <= high){
            int mid = (low+high)/2;
            if (list.get(mid) >= target)
                high = mid - 1;
            else low = mid+ 1;
        }
        return low;
    }
    public int maxMoves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] arr : dp)
            Arrays.fill(arr,-1);
        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, maximumMove(grid,i,0,-1,n,m,dp));
        }
        return max;
    }

    private int maximumMove(int[][] grid, int i, int j, int prev, int n, int m,int[][] dp){
        if (j == m-1)
            return 0;
       int[] dir = {-1,0,1};
       int move = 0;
       for (int num : dir){
           int x = i + num;
           int y = j + 1;
           if (x >= 0 && j < m && x < m && grid[x][y] > prev){
               move = Math.max(move, maximumMove(grid, x, y, prev, n, m, dp));
           }
       }
       dp[i][j] = move +1;
       return dp[i][j];
    }

    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;
        Arrays.sort(nums);
        int option1 = nums[n - 4] - nums[0];
        int option2 = nums[n - 3] - nums[1];
        int option3 = nums[n - 2] - nums[2];
        int option4 = nums[n - 1] - nums[3];
        return Math.min(Math.min(option1, option2), Math.min(option3, option4));

    }

    public ListNode mergeNodes(ListNode head) {
        ListNode current = new ListNode(-1);
        ListNode ans = current;
        int sum = 0;
        while (head != null){
            if (head.val == 0){
                if (sum > 0){
                    current.next = new ListNode(sum);
                    current = current.next;
                    sum = 0;
                }
            }
            sum += head.val;
            head = head.next;
        }
        return ans.next;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int current = 1;
        int min = Integer.MAX_VALUE;
        int prev = head.val;
        ListNode cur = head;
        cur = cur.next;
        List<Integer> list = new ArrayList<>();
        while (cur != null){
            if (cur.next == null){
                break;
            }
            if (isCritical(cur.val,cur.next.val,prev)){
                list.add(current);
            }
            current++;
            prev = cur.val;
            cur = cur.next;
        }
        int[] ans = new int[2];
        for (int i = 1; i < list.size(); i++){
            min = Math.min(min, list.get(i) - list.get(i-1));
        }
        ans[1] = list.size() > 1 ? list.get(list.size()-1) - list.get(0) : -1;
        ans[0] = min == Integer.MAX_VALUE ? -1 : min;
        return ans;
    }
    private boolean isCritical(int cur, int next, int prev){
        return cur > prev && cur > next || cur < prev && cur < next;
    }

    public int passThePillow(int n, int time) {
        int num = (int) Math.ceil((double) time /n);
        System.out.println(num);
        boolean isFront = num % 2 == 0;
        int ans = time % n;
        System.out.println("ans "+ans);
        if (isFront)
            return n - ans - 1;
        else return ans+1;
    }


    public static String FirstNonRepeating(String s) {
       Queue<Character> queue = new LinkedList<>();
       StringBuilder builder = new StringBuilder();
       Map<Character, Integer> map = new HashMap<>();
       for (char c : s.toCharArray()){
           map.put(c, map.getOrDefault(c, 0)+1);
           queue.add(c);

           while (!queue.isEmpty() && map.get(queue.peek()) > 1)
               queue.poll();
           if (queue.isEmpty())
               builder.append('#');
           else builder.append(queue.peek());
       }
       return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(FirstNonRepeating("aabc"));

    }
}
