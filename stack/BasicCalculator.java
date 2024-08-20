package stack;

import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result  = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) -'0';
                    i++;
                }
                result += num*sign;
                i--;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result = stack.pop() * result + stack.pop();
            }
        }
        return result;
    }
}
