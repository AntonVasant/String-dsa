package days;

import java.util.*;

public class MaxOfMinInWindow {

    static int [] nearestSmallestTower(int [] arr){
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        for (int i = n -1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            right[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int leftDist = i - left[i];
            int rightDist = right[i] - i;
            if (left[i] != -1 && right[i] != -1) {
                if (leftDist < rightDist || (leftDist == rightDist && (arr[left[i]] < arr[right[i]]))) {
                    ans[i] = left[i];
                } else ans[i] = right[i];
            } else {
                if (right[i] != -1)
                    ans[i] = right[i];
                else ans[i] = left[i];
            }
        }
        return ans;
    }


    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        map.put('^',3);
        map.put('*',2);
        map.put('/',2);
        map.put('+',1);
        map.put('-',1);
        for (char c : s.toCharArray()){
            if (Character.isLetter(c) || Character.isDigit(c))
                postfix.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfix.append(stack.pop());
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c))
                    postfix.append(stack.pop());
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            postfix.append(stack.pop());
        return postfix.toString();
    }
    public int minLength(String s, int n) {
        Stack<Character> stack = new Stack<>();
        String[] validPairs = {"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"};
        Set<String> set = new HashSet<>(Arrays.asList(validPairs));
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                String pair = ""+ch+top;
                System.out.println(pair);
                if (set.contains(pair))
                    stack.pop();
                continue;
            }
            stack.push(ch);
        }
        System.out.println(stack);
        return stack.size();
    }
    public static int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] left =  new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            left[i] = stack.isEmpty() ? i+1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        int ans = 0;
        int mod = 1000000007;
        for (int i = 0; i < n; i++){
            ans = (ans + (arr[i] * left[i] * right[i])) % mod;
        }
        return ans;
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1) return new ArrayList<>(List.of(nums[0]));
        int[] dp = new int[n];
        int[] hash = new int[n];
        int max = 0;
        int last = -1;
        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }

                if (dp[i] > max){
                    max = dp[i];
                    last = i;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (last != -1){
            list.add(nums[last]);
            last = hash[last];
        }
        return list;
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};
        MaxOfMinInWindow window = new MaxOfMinInWindow();

    }
}
