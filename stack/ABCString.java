package stack;

import java.util.List;
import java.util.Stack;

public class ABCString {
    public static String removeBrackets(String s){
        Stack<Integer> stack = new Stack<>();
        boolean[] redundant = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(')
                stack.push(i);
            else if (c == ')'){
                if (!stack.isEmpty()){
                    int left = stack.pop();
                    if (isRedundant(s, left, i)){
                        redundant[left] = true;
                        redundant[i] = true;
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (!redundant[i])
                builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeBrackets("()()))(()"));
    }

    private static boolean isRedundant(String s, int i, int j){
        boolean isOperator = false;
        for (char c : s.toCharArray()){
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                isOperator = true;
                break;
            }
        }
        if (!isOperator)
            return true;
        char left = i > 0 ? s.charAt(i-1) : ' ';
        char right = j < s.length()-1 ? s.charAt(j+1) : ' ';
        return (isOperator(left) && isOperator(right));
    }

    private static boolean isOperator(char c){
        return c != '+' && c != '-' && c != '*' && c != '/';
    }


    public int sumOfMax(List<Integer> arr) {
        int n = arr.size();
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && arr.get(stack.peek()) <= arr.get(i))
                stack.pop();
            left[i] = stack.isEmpty() ? i+1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr.get(stack.peek()) >=  arr.get(i))
                stack.pop();
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i  < n; i++){
            ans += arr.get(i) * left[i] * right[i];
        }
        return ans;
    }

 
}
