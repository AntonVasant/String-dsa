package stack;

import java.util.Stack;

public class Decode {
    public static void decode(String s){
        Stack<Integer> stack = new Stack<>();
        Stack<StringBuilder> stringBuilderStack = new Stack<>();
        int k = 0;
        StringBuilder current = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (c == '[') {
                stack.push(k);
                stringBuilderStack.push(current);
                k = 0;
                current = new StringBuilder();
            } else if (c == ']') {
                StringBuilder sb = stringBuilderStack.pop();
                int l = stack.pop();
                for (int i = 0; i < l; i++){
                    sb.append(current);
                }
                current = sb;
            }
            else current.append(c);
        }
        System.out.println(current);
    }
}
