package stack;


import graph.FreedomTrail;

import javax.security.auth.login.AccountLockedException;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

class GFG{
    public int findMaxDiff(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                right[stack.pop()] = arr[i];
            stack.push(i);
        }
        stack.clear();
        for (int i = n-1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                left[stack.pop()] = arr[i];
            stack.push(i);
        }
        int difference = Integer.MIN_VALUE;
        for (int i = 0 ; i < n; i++){
            int temp = Math.abs(left[i] - right[i]);
            if (temp > difference)
                difference = temp;
        }
        return difference;
    }


    //no array space
    public int findDiff(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int difference = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && stack.peek() >= arr[i])
                stack.pop();
            int leftMin = stack.isEmpty() ? 0 : stack.peek();
            stack.push(arr[i]);
            int j = i +1;
            while (j < n && arr[j] >= arr[i])
                j++;
            int rightMin = j == n ? 0 : arr[j];

            int min = Math.abs(rightMin - leftMin);
            if (difference < min)
                difference = min;
        }
        return difference;
    }


    public String removeKdigits(String S, int K) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()){
            while (!stack.isEmpty() && K > 0 && stack.peek() > c){
                K--;
                stack.pop();
            }
            stack.push(c);
        }
        while (K > 0 && !stack.isEmpty()){
            stack.pop();
            K--;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty())
            builder.append(stack.pop());
        builder.reverse();
        while (builder.length() > 1 && builder.charAt(0) == '0')
            builder.deleteCharAt(0);
        return builder.toString();
    }

    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        int sum1 = Arrays.stream(S1).sum();
        int sum2 = Arrays.stream(S2).sum();
        int sum3 = Arrays.stream(S3).sum();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < N1 && j < N2 && k < N3){
            if (sum1 == sum2 && sum2 == sum3)
                return sum1;
            else if (sum1 < sum2 && sum1 < sum3)
                sum1 -= S1[i++];
            else if (sum2 < sum1 && sum2 < sum3)
                sum2 -= S2[j++];
            else sum3 -= S3[k++];
        }
        return 0;
    }

    public static int[] help_classmate(int arr[], int n)
    {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                arr[stack.pop()] = arr[i];
            stack.push(i);
        }
        while (!stack.isEmpty())
            arr[stack.pop()] = -1;
        return arr;
    }

    public static int[] asteroidCollision(int N, int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids){
            boolean isDestroyed = false;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                if (Math.abs(asteroid) > stack.peek())
                    stack.pop();
                else if (Math.abs(asteroid) == stack.peek()) {
                    isDestroyed = true;
                    stack.pop();
                    break;
                }
                else {
                    isDestroyed = true;
                    break;
                }
            }
            if (!isDestroyed)
                stack.push(asteroid);
        }
        int n = stack.size();
        int[] res = new int[n];
        for (int i = n-1; i >= 0; i--)
            res[i] = stack.pop();
        return res;
    }

    static long solve(int X,int Y, String S){
        return getAnswer(X,Y, S);
    }

    private static long getAnswer(int x, int y, String str){
        if (y > x){
            str = new StringBuilder(str).reverse().toString();
            int temp = x;
            x = y;
             y = temp;
        }
        StringBuilder remain = new StringBuilder();
        long ans = findAnswer(str, "pr",x, remain);
        ans += findAnswer(remain.toString(), "rp", y, null);
        return ans;
    }

    private static long findAnswer(String str, String pattern, int points, StringBuilder remaining){
        StringBuilder stack = new StringBuilder();
        long reward = 0;
        for (char c : str.toCharArray()){
            if (stack.length() > 0 && stack.charAt(stack.length()-1) == pattern.charAt(0) && c == pattern.charAt(1)){
                reward += points;
                stack.deleteCharAt(stack.length()-1);
            }
            else stack.append(c);
        }
        if (remaining != null)
            remaining.append(stack);
        return reward;
    }

    public static int finLength(int N, int[] color, int[] radius) {
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < N; i++){
            if (!stack.isEmpty() && stack.peek()[0] == color[i] && stack.peek()[1] == radius[i])
                stack.pop();
           else stack.push(new int[]{color[i], radius[i]});
        }
        return stack.size();
    }

    public static int checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == ')'){
                boolean found = false;
                while (!stack.isEmpty() && stack.peek() != '('){
                    char ch = stack.pop();
                    if (ch == '/' || ch == '+' || ch == '-' || ch == '*')
                        found = true;
                }
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                if (!found)
                    return 1;
            }
            else stack.push(c);
        }
        return 0;
    }

    public static int isStackPermutation(int n, int[] ip, int[] op) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < n; i++){
            stack.push(ip[i]);
            while (!stack.isEmpty() && stack.peek() == op[index]){
                stack.pop();
                index++;
            }
        }
        System.out.println(index);
        System.out.println(stack);
        return stack.isEmpty() ? 1 : 0;
    }

    public static int SaveGotham(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int ans = 0;
        for (int j : arr) {
            while (!stack.isEmpty() && stack.peek() < j) {
                ans += j;
                stack.pop();
            }
            stack.push(j);
        }
        return ans;
    }

    public static String removePair(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c :s.toCharArray()){
            if (!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else stack.push(c);
        }
        StringBuilder builder = new StringBuilder();
        for (char c : stack)
            builder.append(c);
        return builder.toString();
    }

    static String lexicographicallySmallest(String S, int k) {
        int n = S.length();
        if ((n & (n-1)) == 0)
            k /= 2;
        else k *= k;
        StringBuilder stack = new StringBuilder();
        for (char c : S.toCharArray()){
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length()-1) > c){
                k--;
                stack.deleteCharAt(stack.length()-1);
            }
            stack.append(c);
        }

        while (k > 0 && stack.length() > 0){
            stack.deleteCharAt(stack.length()-1);
            k--;
        }
        return stack.toString();
    }

    void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        if (st.isEmpty())
            return;
        int pop = st.pop();
        clonestack(st, cloned);
        helper(pop, cloned);
    }

    private void helper(int num, Stack<Integer> stack){
        if (stack.isEmpty()){
            stack.push(num);
            return;
        }
        int temp = stack.pop();
        helper(temp, stack);
        stack.push(temp);
    }

    public static void main(String[] args) {
        GFG gfg = new GFG();
        SaveGotham(new int[]{112, 133, 161, 311, 122, 512, 1212, 0, 19212});
    }
}