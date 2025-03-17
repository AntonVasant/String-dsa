package stack;

import java.util.Stack;

public class BasicCalculator2 {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        char sigh = '+';
        int n = s.length();
        for (int i = 0; i < s.length(); i++){
            char c  = s.charAt(i);
            if (Character.isDigit(c)){
                current = current * 10  + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == n-1){
                if (sigh == '+')
                    stack.push(current);
                else if (sigh == '-') {
                    stack.push(-current);
                } else if (sigh == '*') {
                    stack.push(current*stack.pop());
                } else if (sigh == '/') {
                    stack.push(stack.pop()/current);
                }
                current = 0;
                sigh = c;
            }
        }
        int res = 0;
        for (int num : stack)
            res += num;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2"));
    }
}
