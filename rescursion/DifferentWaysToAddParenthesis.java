package rescursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthesis {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                String left = expression.substring(0,i);
                String right = expression.substring(i+1);
                List<Integer> leftNumbers = diffWaysToCompute(left);
                List<Integer> rightNumbers = diffWaysToCompute(right);
                for (int n : leftNumbers){
                    for (int m : rightNumbers){
                        switch (c){
                            case '+' :{
                                list.add(n + m);
                                break;
                            }
                            case '-' :{
                                list.add(n - m);
                                break;
                            }
                            case '*' :{
                                list.add(n * m);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (list.isEmpty())
            list.add(Integer.parseInt(expression));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("1+2-3"));
    }
}
