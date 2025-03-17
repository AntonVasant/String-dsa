package array;

import linkedList.Node;

import java.util.*;

class Project{
    int capital;
    int profit;

    public Project(int capital,int profit){
        this.capital = capital;
        this.profit = profit;
    }

}
public class IPO {
    public static int maximum(int w, int[] capital, int[] profit, int k){
        int n = capital.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++)
            projects[i] = new Project(capital[i],profit[i]);

        Arrays.sort(projects,(a,b) -> a.capital - b.capital);
        PriorityQueue<Project> pq = new PriorityQueue<>((a,b) -> b.profit - a.profit);
        int i = 0;
        while (k > 0){
            while (i < n && projects[i].capital <= w){
                pq.offer(projects[i]);
                i++;
            }
            if (pq.isEmpty()) break;
            w += pq.poll().profit;
            k--;
         }
        return w;
    }

    public List<Integer> findMajority(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums){
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
            else if (count1 == 0){
                candidate1 = num;
                count1++;
            }
            else if (count2 == 0){
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums){
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        int eligible = nums.length/3;
        List<Integer> list = new ArrayList<>();
        if (count1 >= eligible)
            list.add(candidate1);
        if (count2 >= eligible)
            list.add(candidate2);

        Collections.sort(list);
        return list;
    }
    public int myAtoi(String s) {
        int sign = 1;
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == ' ')
            i++;
        if (s.charAt(i) == '-')
            sign = -1;
        int value= 0;
        while (i < n){
            int digit = s.charAt(i) - '0';
            if (value > Integer.MAX_VALUE/10){
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value = value * 10 + digit;
            i++;
        }
        return value * sign;
    }
    Node divide(Node head) {
        Node oddHead = new Node(-1);
        Node evenHead = new Node(-1);
        Node oddCur = oddHead;
        Node evenCur = evenHead;
        Node current = head;
        while (current != null){
            if (current.data % 2 == 0) {
                evenCur.next = current;
                evenCur = evenCur.next;
            }
            else {
                oddCur.next = current;
                oddCur = oddCur.next;
            }
            current = current.next;
        }
        evenCur.next = oddHead.next;
        oddCur.next = null;
        return evenHead.next;
    }
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.addAll(arr);
        Node dummy = new Node(-1);
        Node current = dummy;
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            current.next = cur;
            current = current.next;
            if (cur.next != null)
                pq.offer(cur.next);
        }

        return dummy.next;
    }
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        int[][] profit = new int[n][2];

        for (int i = 0; i < n; i++){
            int diff = Math.abs(arr[i] - brr[i]);
            profit[i][0] = diff;
            profit[i][1] = i;
        }

        Arrays.sort(profit, (a,b) -> b[0] - a[0]);
        long ans = 0;
        for (int i = 0; i < n; i++){
            int index = profit[i][1];
            if (x > 0 && arr[index] > brr[index] || y <= 0) {
                ans += arr[index];
                x--;
            }
            else {
                ans += brr[index];
                y--;
            }
        }

        return ans;
    }
    //minimum jumps
    public int minimizeCost(int k, int[] arr) {
       int n = arr.length;
       int[] dp = new int[n];
       Arrays.fill(dp,-1);
       return minimumHelper(arr,k,n-1,dp);
    }
    private int minimumHelper(int[] arr, int k, int index, int[] dp){
        if (index == 0) return 0;
        if (dp[index] != -1) return dp[index];
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++){
            if (index - j >= 0){
                int current = Math.abs(arr[index] - arr[index - j]) + minimumHelper(arr,k,index-j,dp);
                ans = Math.min(current, ans);
            }
        }
        dp[index] = ans;
        return dp[index];
    }

    public int totalWays(int N, int M, int[][] grid) {
        int[][] dp = new int[N][M];
        for (int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return totalPaths(grid,0,0,dp);
    }
    private int totalPaths(int[][] grid, int i, int j,int[][] dp){
        if (i == grid.length-1 && j == grid[0].length-1)
            return 1;
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1)
            return 0;
        if (dp[i][j] != -1) return dp[i][j];
        grid[i][j] = 1;
        int one = totalPaths(grid, i, j+1,dp);
        int two = totalPaths(grid, i+1, j,dp);
        grid[i][j] = 0;
        dp[i][j] = one + two;
        return one  + two;
    }
    static Node subLinkedList(Node head1, Node head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node p1 = head1;
        int borrow = 0;
        Node p2 = head2;
        Node dummy = new Node(-1);
        Node cur = dummy;
        while (p1 != null || p2 != null){
            int one = p1 != null ? p1.data : 0;
            int two = p2 != null ? p2.data : 0;

            int diff = one - two - borrow;
            if (diff < 0){
                borrow = 1;
                diff += 10;
            }
            else borrow = 0;
            cur.next = new Node(diff);
            cur = cur.next;
        }
        Node res = reverse(dummy.next);
        return removeLeadingZero(res);
    }
    private static Node removeLeadingZero(Node head){
        while (head != null && head.data == 0)
            head = head.next;
        return head;
    }
    private static Node reverse(Node head){
        Node current = head;
        Node prev = null;
        Node next;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static ArrayList<Integer> countEleLessThanOrEqual(int[] a, int[] b) {
        Arrays.sort(b);
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : a){
            list.add(binarySearch(b,num));
        }
        return list;
    }
    private static int binarySearch(int[] arr, int num){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] <= num)
                low = mid;
            else  high = mid - 1;
        }
        return low;
    }
    public static int minChar(String s) {
        int n = s.length();
        int longest = helperPalindrome(s,new StringBuilder(s).reverse().toString());
        return n - longest;
    }
    private static int helperPalindrome(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        for (int[] arr : dp)
            System.out.println(Arrays.toString(arr));

        return dp[n-1][m-1];
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder builder = new StringBuilder();
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        int pendingIndex = -1;
        for (int i = 25; i>= 0; i--){
            if (freq[i] == 0) continue;
            if (pendingIndex > 0){
                builder.append((char) (i + 'a'));
                freq[i]--;
                i = pendingIndex;
                pendingIndex = -1;
            }
            else {
                for (int j = 0; j < repeatLimit && freq[i] > 0; j++, freq[i]--){
                    builder.append((char) (i + 'a'));
                }
                if (freq[i] > 0)
                    pendingIndex = i + 1;
            }
        }
        return builder.toString();
    }
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            if (grid[i][0] == 1)
                flipRow(grid,i);
        }
        for (int i = 0; i < m; i++){
            int count = 0;
            for (int j = 0; j < n; j++){
                if (grid[j][i] == 1) count++;
            }
            if (count > n/2.0)
                flipCol(grid,i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++){
            int num = 0;
            for (int j = 0; j < m; j++) {
                num = (num << 1) | grid[i][j];
            }
            ans += num;
        }
        return ans;
    }
    private void flipRow(int[][] grid, int row){
        int col = grid[0].length;
        for (int j = 0; j < col; j++)
            grid[row][j] = 1 - grid[row][j];
    }
    private void flipCol(int[][] grid, int col){
        int row = grid.length;
        for (int i = 0; i < row; i++)
            grid[i][col] = 1 - grid[i][col];
    }
    public int[] advantageCount(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        for (int num : nums1)
            list.add(num);
        for (int i = 0; i < nums1.length; i++){
            int index = binarySearch(list, nums2[i]);
            index = Math.max(index, 0);
            nums2[i] = list.get(index);
            list.remove(index);
        }
        return nums2;
    }
    private int binarySearch(List<Integer> list, int current){
        int low = 0;
        int high = list.size()-1;
        int index = -1;
        while (low <= high){
            int mid = (low + high)/2;
            if (list.get(mid) > current){
                index = mid;
                high = mid - 1;
            }
            else  low = mid + 1;
        }
        return index;
    }
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int current = startFuel;
        int i  = 0;
        int stop = 0;
        int n = stations.length;
        while (current < target){
            while (i <  n && stations[i][0] <= current){
                pq.add(stations[i][1]);
                i++;
            }
            if (pq.isEmpty())
                return -1;
            current += pq.poll();
            stop++;
        }
        return stop;
    }
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n-1];
        int min = nums[0];
        int difference = (max  - min );
        for (int i = 0; i < n-1; i++){
            int currentMin = Math.min(min + k, nums[i+1] - k);
            int currentMax = Math.max(max - k, nums[i] + k);
            difference = Math.min(difference, currentMax - currentMin);
        }
        return difference;
    }
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int day = 0;
        int index = 0;
        int n = events.length;
        int result = 0;

        // Priority queue to keep track of the end days of events
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (!pq.isEmpty() || index < n) {

            if (pq.isEmpty()) {
                day = events[index][0];
            }

            while (index < n && events[index][0] <= day) {
                pq.offer(events[index][1]);
                index++;
            }
            pq.poll();
            result++; // Increment the count of attended events
            day++;
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }

        return result;
    }
    int maxSum(int[] arr) {
        int n = arr.length;
        int total = Arrays.stream(arr).sum();
        int initial = 0;
        for (int i = 0; i < n; i++)
            initial += arr[i] * i;
        int ans = initial;
        for (int i = 1; i <= n; i++){
            initial = initial + total - n * arr[n-i];
            ans = Math.max(ans, initial);
        }
        return ans;
    }
    public static void main(String[] args) {
        IPO ipo = new IPO();

    }
}
