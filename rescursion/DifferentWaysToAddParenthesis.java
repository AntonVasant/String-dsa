package rescursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthesis {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                String left = expression.substring(0,i);
                String right = expression.substring(i+1);
                List<Integer> first = diffWaysToCompute(left);
                List<Integer> second = diffWaysToCompute(right);
                for (int f : first){
                    for (int s : second){
                        if (c == '+'){
                            result.add(f+s);
                        }
                        else if (c == '-'){
                            result.add(f-s);
                        }
                        else if (c == '*'){
                            result.add(f*s);
                        }
                    }
                }
            }
            if (result.isEmpty()){
                result.add(Integer.parseInt(expression));
            }
        }
        return result;
    }
}
