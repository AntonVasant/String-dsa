package stack;

import java.util.Stack;

public class StringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (!stack.isEmpty() && stack.peek() != c && Character.toLowerCase(c) == Character.toLowerCase(stack.peek())){
                stack.pop();
            }
            else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
