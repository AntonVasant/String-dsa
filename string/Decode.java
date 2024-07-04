package string;

import java.util.Stack;

public class Decode {
    public static String decode(String str){
        Stack<String> stack =  new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;
        for (char c : str.toCharArray()){
            if (Character.isDigit(c)){
                k = k *10 + (c-'0');
            } else if (c == '[') {
                countStack.push(k);
                stack.push(current.toString());
                k = 0;
                current =  new StringBuilder();
            } else if (c == ']') {
                int time = countStack.pop();
                StringBuilder sb = new StringBuilder(stack.pop());
                for (int i = 0; i < time; i++){
                    sb.append(current);
                }
                current = sb;
            }else current.append(c);
        }
         return current.toString();
    }
}
