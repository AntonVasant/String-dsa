package stack;

import java.util.Stack;

public class PolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                int n1 = stack.pop();
                int n2 = stack.pop();

                switch (s){
                    case "+":{
                        stack.push(n1+n2);
                        break;
                    }

                    case "-":{
                        stack.push(n2-n1);
                        break;
                    }

                    case "/":{
                        stack.push(n2/n1);
                        break;
                    }

                    case "*":{
                        stack.push(n1*n2);
                        break;
                    }

                }
            }else stack.push(Integer.parseInt(s));
        }
        return stack.peek();
    }
}
