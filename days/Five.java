package days;

import java.util.*;


class pair {
    long first, second;

    public pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}
public class Five {

    // if liner like ()() score increases by 1 if (()) nested then doubles
    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char c : s.toCharArray()){
            if (c == '(')
                stack.push(0);
            else {
                int current = stack.pop();
                int score = current == 0 ? 1 : 2 * current;
                stack.push(stack.pop() + score);
            }
        }
        return stack.pop();
    }






    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1000000009;

        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            next[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            prev[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            int left = i - prev[i];
            int right = next[i] - i;
            res += (arr[i] * left * right) % MOD;
        }
        return res;
    }


    public static int evaluatePostFix(String S){
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()){
            if (c == ' ') continue;
            if (Character.isDigit(c))
                stack.push(c - '0');
            else {
                int result = 0;
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                switch (c){
                    case '+': {
                        result = operand1 + operand2;
                        break;
                    }
                    case '-': {
                        result = operand2 - operand1;
                        break;
                    }
                    case '*': {
                        result = operand1 * operand2;
                        break;
                    }
                    case '/': {
                        result = operand2 / operand1;
                        break;
                    }
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
    static int[] print_next_greater_freq(int[] arr, int n){
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0)+1);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            int current = map.get(arr[i]);
            while (!stack.isEmpty() && map.get(stack.peek()) <= current)
                stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }



    // the least maximum on the right side
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int i = n -1; i >= 0; i--){
            int high = sortedList.size()-1;
            int low = 0;
            int index = -1;
            while (low <= high){
                int mid = (low + high)/2;
                if (sortedList.get(mid) > arr[i]){
                    index = mid;
                    high = mid - 1;
                }
                else  low = mid +1;
            }
            if (index >= 0) list.add(sortedList.get(index));
            else list.add(-1);
            sortedList.add(low,arr[i]);
        }
        Collections.reverse(list);
        return list;
    }


    public int CheapestFLight(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] f : flights){
            map.putIfAbsent(f[0],new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        pq.offer(new int[]{0,src,k});
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int currentCost = cur[0];
            int currentStop = cur[1];
            int left = cur[2];
            if (currentStop == dst)
                return currentCost;
            if (left > 0){
                for (int[] num : map.getOrDefault(currentStop, new ArrayList<>())){
                    int newCost = currentCost  + num[1];
                    if (newCost < minCost[num[0]]){
                        minCost[num[0]] = newCost;
                        pq.offer(new int[]{newCost, num[0],left-1});
                    }
                }
            }
        }
        return -1;
    }
    static int catchThieves(char[] arr, int n, int k){
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P')
                queue.offer(new int[]{i,k});
        }
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int start = Math.max(0,current[0]-k);
            int end = Math.min(n,current[0]+k);
            for (;start < end; start++){
                if (arr[start] == 'T'){
                    ans++;
                    arr[start] = 'P';
                }
            }
        }
        return ans;
    }
    public List<String> all_longest_common_subsequences(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        Set<String> set = new HashSet<>();
        getAllSequence(dp,s,t,set,new StringBuilder(),n,m);

        return new ArrayList<>(set);
    }
    private void getAllSequence(int[][] dp, String s, String t, Set<String> list, StringBuilder builder,int i, int j){
        if (i == 0 || j == 0){
            list.add(builder.reverse().toString());
            builder.reverse();
            return;
        }
        if (s.charAt(i-1) == t.charAt(j-1)){
            builder.append(s.charAt(i-1));
            getAllSequence(dp,s,t,list,builder,i-1,j-1);
            builder.deleteCharAt(builder.length()-1);
        }
        else {
            if (dp[i-1][j] >= dp[i][j-1])
                getAllSequence(dp,s,t,list,builder,i-1,j);
            if (dp[i][j-1] >= dp[i-1][j])
                getAllSequence(dp, s, t, list, builder, i, j-1);
        }
    }


    /*
    Given an integer array nums and an integer k,
     return true if it is possible to divide this array into k non-empty subsets
    whose sums are all equal.
     */
    public boolean isKPartitionPossible(int[] arr, int k) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        int target = sum/k;
        if (sum%k != 0) return false;
        if (arr[n-1] > target) return false;
        return canPartition(arr,new int[k],n-1,target);
    }

    private boolean canPartition(int[] arr, int[] bucket, int index,int target){
        if (index < 0) return true;

        for (int i = 0; i < arr.length; i++){
            if (bucket[i] + arr[index] <= target){
                bucket[i] += arr[index];
               if(canPartition(arr,bucket,index-1,target))
                   return true;
               bucket[i] -= arr[index];
            }
            if (bucket[i] == 0) break;
        }
        return false;
    }


    public static ArrayList<String> addOperators(String S, int target) {
        ArrayList<String> list = new ArrayList<>();
        calculate(target,S,0,0,0,"",list);
        return list;
    }

    private static void calculate(int target, String s, int index, long current, long prev,
                                  String expression,ArrayList<String> list){
        if (index == s.length()){
            if (current == target)
                list.add(expression);
            return;
        }

        for (int i = index; i < s.length(); i++){
            if (i > index && s.charAt(index) == '0') break;
            String currentSub = s.substring(index, i+1);
            long number  = Long.parseLong(currentSub);
            if (index == 0){
                calculate(target, s, i+1, number, number, currentSub, list);
            }
            else {
                calculate(target, s, i+1, current + number, number,
                        expression+"+"+currentSub, list);
                calculate(target, s, i+1, current - number, -number,
                        expression+"-"+currentSub, list);
                calculate(target, s, i+1, current - prev + prev * number,
                        prev * number, expression+"*"+currentSub, list);
            }
        }
    }

    public static String kthPermutation(int n,int k) {
        List<Integer> list = new ArrayList<>();
        int[] factorials = new int[n];
        k--;
        factorials[0] = 1;
        for (int i = 1; i < n; i++){
            factorials[i] = factorials[i-1] * i;
        }

        for (int i = 1; i <= n; i++)
            list.add(i);

        StringBuilder builder = new StringBuilder();
        for (int i = n; i >= 0; i--){
            int index = k/factorials[i-1];
            builder.append(list.get(index));
            list.remove(index);
            k %= factorials[i-1];
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(findGreatestSmallerOnLeft(new int[]{4,3,2,5,7,1,2,8,4})));
    }
    public static int[] findGreatestSmallerOnLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int high = sortedList.size()-1;
            int low = 0;
            int index = -1;
            while (low <= high){
                int mid = (low + high)/2;
                if (sortedList.get(mid)  < arr[i]){
                    index = mid;
                    low = mid + 1;
                }
                else high = mid - 1;
            }
            result[i] = index >= 0 ? sortedList.get(index) : -1;
            sortedList.add(low, arr[i]);
        }
        System.out.println(sortedList);
        return result;
    }

}
