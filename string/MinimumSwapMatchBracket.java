package string;

import java.util.Stack;

public class MinimumSwapMatchBracket {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) count++;
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        if(count == 0) return 0;
        return (count+1) /2;
    }
}
