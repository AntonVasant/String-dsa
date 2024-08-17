package stack;

import java.util.Stack;

public class ParseBooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c: expression.toCharArray()){
            if (c == ',') continue;
            else if (c != ')') {
                stack.push(c);
            }
            else {
                Stack<Character> temp = new Stack<>();
                while (stack.peek() != '(')
                    temp.push(stack.pop());
                stack.pop();
                char operator = stack.pop();
                boolean res = helper(operator,temp);
                stack.push(res ? 't' : 'f');
            }
        }
        return stack.pop() == 't';
    }

    private boolean helper(char operator,Stack<Character> stack){
        if (operator == '!')
            return stack.pop() == 'f';
        else if (operator == '&') {
            while (!stack.isEmpty()){
                if (stack.pop() == 'f') return false;
            }
            return true;
        } else if (operator == '|') {
            while (!stack.isEmpty()){
                if (stack.pop() == 't') return true;
            }
            return false;
        }
        return false;
    }
}
