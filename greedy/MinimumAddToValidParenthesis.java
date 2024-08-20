package greedy;

import java.util.Stack;

public class MinimumAddToValidParenthesis {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : s.toCharArray()){
            if (c == ')'){
                if (!stack.isEmpty()) stack.pop();
                else count++;
            } else if (c == '(') {
                stack.push(c);
            }
        }
        return stack.size()+count;
    }
}
