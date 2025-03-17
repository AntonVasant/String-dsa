package greedy;


import java.util.*;

public class PrimeNumberMakeOrder {
    public boolean primeSubOperation(int[] nums) {
        int max = 0;
        for (int n : nums)
            max = Math.max(max,n);
        List<Integer> list = generatePrime(max);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] <= prev){
                boolean increasing = false;
                int size = list.size();
                for (int j = size-1; j >= 0; j--){
                    int current = list.get(j);
                    if (current < prev){
                        if (prev - current < nums[i]){
                            increasing = true;
                            break;
                        }
                    }
                }
                if (!increasing) return false;
                else prev = nums[i];
            }
        }
        return true;
    }


    private List<Integer> generatePrime(int max){
        boolean[] arr = new boolean[max+1];
        List<Integer> list = new ArrayList<>();
        Arrays.fill(arr,true);
        arr[0] = arr[1] = false;
        for (int i = 2; i * i <= max; i++){
            if (arr[i]){
                for (int j = i * i; j <= max; j+= i)
                    arr[j] = false;
            }
        }
        for (int i = 2; i <= max; i++){
            if (arr[i])
                list.add(i);
        }
        return list;
    }

    public void segregateElements(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                int temp = arr[i];
                for (int j = i; j > index; j--){
                    arr[j] = arr[j-1];
                }
                arr[index++] = temp;
            }
        }
    }

    public void moveSetNumbersToEnd(int[] arr, Set<Integer> set){
        int index = 0 ;
        for (int i = 0; i < arr.length; i++){
            if (!set.contains(arr[i])){
                int temp = arr[i];
                for (int j = i; j > index; j--){
                    arr[j] = arr[j-1];
                }
                arr[index++] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    String minSum(int[] arr) {
        Arrays.sort(arr);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            if (i % 2 == 0)
                num1.append(arr[i]);
            else num2.append(arr[i]);
        }

        int num = Integer.parseInt(num1.toString());
        int n = Integer.parseInt(num2.toString());
        return String.valueOf(num+n);
    }

    static String findLargest(int N, int S){
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++){
            if (S >= 9){
                ans.append(9);
                S -= 9;
            }
            else {
                ans.append(S);
                S = 0;
            }
        }
        return ans.toString();
    }

    void nextPermutation(int[] arr) {
        int i = arr.length-2;
        while (i >= 0 && arr[i] >= arr[i+1])
            i--;
        if (i >= 0){
            int j = arr.length-1;
            while (arr[j] <= arr[i])
                j--;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        reverse(arr,i+1);
    }

    private void reverse(int[] arr, int start){
        int n = arr.length-1;
        while (start < n){
            int temp = arr[start];
            arr[start] = arr[n];
            arr[n] = temp;
            start++;
            n--;
        }
    }

    public int activitySelection(List<Integer> start, List<Integer> end) {
        int n = start.size();
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++){
            activities[i][0] = start.get(i);
            activities[i][1] = end.get(i);
        }
        selectionSort(activities);
        int count = 1;
        int lastOver = activities[0][1];
        for (int i = 1; i < n; i++){
            if (activities[i][0] > lastOver){
                count++;
                lastOver = activities[i][1];
            }
        }
        return count;
    }

    private void selectionSort(int[][] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (arr[j][0] < arr[minIndex][0])
                    minIndex = j;
            }
            int[] temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    public static boolean matSearch(int mat[][], int x) {
        int row = mat.length;
        int col = mat[0].length-1;
        int i = 0;
        while (i < row && col >= 0){
            if (mat[i][col] == x)return true;
            else if (mat[i][col] < x) {
                col--;
            }
            else row++;
        }
        return false;
    }

    public int countWays(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper(s,0,map);
    }

    private int helper(String s, int index,Map<Integer,Integer> map){
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (map.containsKey(index)) return map.get(index);
        int result = 0;
        result += helper(s,index+1,map);
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index,index+2)) < 27)
            result += helper(s,index+2,map);
        map.put(index,result);
        return result;
    }


    public static int findElement(List<Integer> arr) {
        int n = arr.size();
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr.get(0);
        for (int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1],arr.get(i));
        }
        right[n-1] = arr.get(n-1);
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.min(right[i+1], arr.get(i));

        for (int i = 1; i < n-1; i++){
            if (arr.get(i) > left[i] && arr.get(i) < right[i]) return i;
        }
        return -1;
    }

    int tour(int petrol[], int distance[]){
        int totalPetrol = 0;
        int totalDistance = 0;
        int remainingPetrol = 0;
        int start = 0;
        for (int i = 0; i < petrol.length; i++){
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            remainingPetrol += petrol[i] - distance[i];

            if (remainingPetrol < 0)
                start = i + 1;
        }
        if (totalDistance > totalPetrol) return -1;

        return start;
    }


    public static long getMaxArea(long hist[]) {
        Stack<Integer> stack = new Stack<>();
        long max = 0;
        int index = 0;
        while (index < hist.length){
            if (stack.isEmpty() || hist[index] < hist[stack.peek()])
                stack.push(index++);
            else {
                long height = hist[stack.pop()];
                long width = stack.isEmpty() ? index : index - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
        }

        while (!stack.isEmpty()){
            long height = hist[stack.pop()];
            long width = stack.isEmpty() ? index : index - stack.peek() - 1;
            max = Math.max(max, height * width);
        }
        return max;
    }

    public int minSwaps(int arr[]) {
        int n = arr.length;
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++){
            array[i][0] = arr[i];
            array[i][1] = i;
        }

        Arrays.sort(array, (a,b) -> a[0] - b[0]);
        int swaps = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visit[i] || array[i][1] == i)
                continue;
            int count = 0;
            int j = i;
            while (!visit[j]){
                visit[j] = true;
                j = array[j][1];
                count ++;
            }
            if (count > 0)
                swaps += count - 1;
        }
        return swaps;
    }

    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++){
            if (arr[i] < 0)
                queue.add(i);
        }
        for (int i = 0; i < n - k +1; i++){
            if (!queue.isEmpty())
                 list.add(arr[queue.peek()]);
            else list.add(0);

            if (!queue.isEmpty() && queue.peek() == i)
                queue.poll();
            if (i + k < n && arr[i + k] < 0)
                queue.offer(i + k);
        }
        return list;
    }


    static int knapSack(int w, int val[], int wt[]) {
        int[][] dp = new int[val.length+1][w+1];
        for (int[] arr : dp)
            Arrays.fill(arr,-1);
        return helper(val,wt,w,0,dp);
    }


    private static int helper(int[] val, int[] wt, int limit, int index, int[][] dp){
        if (limit == 0 || index == val.length) return 0;
        if (dp[index][limit] != -1) return dp[index][limit];
        int take = 0;
        if (limit >= wt[index]){
            take = val[index] + helper(val,wt,limit - wt[index],index,dp);
        }
        int non = helper(val,wt,limit,index+1,dp);
        return dp[index][limit] = Math.max(take,non);
    }


    private static final int MOD = 1_000_000_007;
    public static int countPartitions(int n, int d, int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if ((sum + d)%2 != 0) return 0;
        int target = (sum+d)/2;
        Integer[][] dp = new Integer[n][target];
        return memoization(arr,0,target,dp);
    }

    private static int memoization(int[] arr, int index, int target,Integer[][] dp){
        if (target == 0) return 1;
        if (index == arr.length) return 0;
        if (dp[index][target] != null) return dp[index][target];
        int take  = 0;
        if (arr[index] <= target)
            take = memoization(arr, index+1, target - arr[index], dp);
        int non = memoization(arr, index+1, target, dp);
        return dp[index][target] = (take + non) % MOD;
    }

    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    int a = arr[i] * arr[i];
                    int b = arr[j] * arr[j];
                    int c = arr[k] * arr[k];

                    if (a + b == c || b + c == a || c + a == b)
                        return true;
                }
            }
        }
        return false;
    }

    public static String multiplyStrings(String s1,String s2)
    {
        StringBuilder ans  = new StringBuilder();
        s1 = s1.replaceFirst("^0+(?!$)", "");
        s2 = s2.replaceFirst("^0+(?!$)", "");
        int m = s1.length();
        int n = s2.length();
        int[] res = new int[m+n];
        for (int i = m-1; i >= 0; i--){
            for (int j = n -1; j >= 0; j--){
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + res[i+j+1];
                res[i+j+1] = sum % 10;
                res[i+j] += sum / 10;
            }
        }

        for (int num : res){
            if (!(ans.length() == 0 && num == 0))
                ans.append(num);
        }
        System.out.println(ans);
        return ans.toString();
    }

    static void rearrange(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n; i++){
            if ((i % 2 == 0 && arr.get(i) < 0) || (i % 2 != 0 && arr.get(i) >= 0)){
                int j = i + 1;
                while (j < n && (i % 2 == 0 && arr.get(j) < 0) || (i % 2 != 0 && arr.get(j) >= 0))
                    j++;
                if (j < n)
                    rotate(arr,i,j);
            }
        }
        System.out.println(arr);
    }

    private static void rotate(ArrayList<Integer> list,int start, int end){
        int temp = list.get(end);
        for (int i = end; i > start; i--){
            list.set(i,list.get(i-1));
        }
        list.set(start,temp);
    }

    int countTriplet(int arr[]) {
        int n = arr.length;
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n-2 ; i++){
            int j = i + 1;
            int k = n - 1;
            while (j < k){
                int sum = arr[j] + arr[k];
                if (sum == arr[i]){
                    count++;
                    k--;
                    j++;
                }
                else if (sum > arr[i])
                    k--;
                else j++;
            }
        }
        return count;
    }

   static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r){
        int n = mid - l+1;
        int m = r - mid ;
        int[] left = new int[n];
        int[] right = new int[m];
        for (int i = 0; i < n; i++)
            left[i] = arr[i+l];
        for (int i = 0; i < m;  i++)
            right[i] = arr[i+mid+1];
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
                arr[l++] = left[i++];
            }
            else arr[l++] = right[j++];
        }

        while (i < left.length)
            arr[l++] = left[i++];
        while (j < right.length)
            arr[l++] = right[j++];
    }

    int countWays(int n) {
        if (n == 0) return 1;
        int two  = 0;
        if (n >= 2)
            two = countWays(n-2);
        int one = countWays(n-1);
        return one + two;
    }


    public int firstElementKTime(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr){
            if (map.containsKey(num)){
                if (map.get(num) >= k) return num;
            }
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return -1;
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 3; i++){
            if (i > 0 && arr[i] ==arr[i-1]) continue;
            for (int j = i+1; j < n- 2; j++){
                if (j > i + 1 && arr[j] == arr[j-1]) continue;
                int l = j+1;
                int m = n-1;
                while (l < m){
                    int sum = arr[i] + arr[j] + arr[l] + arr[m];
                    if (sum == k){
                        list.add(new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[l],arr[m])));
                        l++;
                        m--;
                    }

                    else if (sum < k)
                        l++;
                    else m--;

                    while (l < m && arr[l] == arr[l+1])
                        l++;
                    while (l < m && arr[m] == arr[m-1])
                        m--;
                }
            }
        }
        return list;
    }


    public int maxSumIS(int arr[], int n)
    {
        int[][] dp = new int[n][n+1];
        for (int[] a : dp)
            Arrays.fill(a,-1);
        return findMax(arr,0,-1,dp);
    }

    private int findMax(int[] arr,int index,int prev,int[][] dp){
        if (index == arr.length) return 0;
        if (dp[index][prev+1] != -1) return dp[index][prev+1];
        int take = 0;
        if (prev == -1 || arr[prev] < arr[index])
            take = arr[index] + findMax(arr,index+1,index,dp);
        int no = findMax(arr,index+1,prev,dp);
        return dp[index][prev+1] = Math.max(take,no);
    }


    public static long sumOfDivisors(int n) {
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++){
            for (int j = i; j <= n; j+= i)
                arr[j] += i;
        }
        long ans = 0;
        for (int i = 1; i <= n; i++)
            ans += arr[i] - i;
        return ans;
    }


    public static String smallestWindow(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s2.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        Map<Character, Integer> currentMap = new HashMap<>();
        int found = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int  n = s1.length();
        for (int right = 0; right < n; right++){
            char c = s1.charAt(right);
            currentMap.put(c,currentMap.getOrDefault(c,0)+1);
            if (map.containsKey(c) && Objects.equals(currentMap.get(c), map.get(c))){
                found++;
                if (found == map.size()){
                    min = Math.min(right - left +1,min);
                    start = left;
                }
            }
            if (found == map.size()){
                while (found == map.size() && map.containsKey(c) && currentMap.get(c) > map.get(c)){
                    char leftChar = s1.charAt(left);
                    currentMap.remove(leftChar);
                    left++;
                    if (map.get(leftChar) > currentMap.get(leftChar))
                        found--;
                }
            }

        }

        return min == Integer.MAX_VALUE ? "" : s1.substring(start,start+min);
    }
    public static void main(String[] args) {
        PrimeNumberMakeOrder prime = new PrimeNumberMakeOrder();

        System.out.println(smallestWindow("timetopractice","toc"));
    }
}
/*
You can perform the following operation as many times as you want:

Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
Return true if you can make nums a strictly increasing array using the above operation and false otherwise.

A strictly increasing array is an array whose each element is strictly greater than its preceding element.
 */