package stack;

import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                ans[index] = i-index;
            }
            stack.push(i);
        }
        return ans;
    }
}
