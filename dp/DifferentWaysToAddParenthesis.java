package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParenthesis {
        Map<String, List<Integer>> memo = new HashMap<>();

        public List<Integer> diffWaysToCompute(String input) {
            if (memo.containsKey(input)) {
                return memo.get(input);
            }

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '+' || c == '-' || c == '*') {
                    String leftExpr = input.substring(0, i);
                    String rightExpr = input.substring(i + 1);

                    List<Integer> leftResults = diffWaysToCompute(leftExpr);
                    List<Integer> rightResults = diffWaysToCompute(rightExpr);

                    for (int left : leftResults) {
                        for (int right : rightResults) {
                            switch (c) {
                                case '+':
                                    result.add(left + right);
                                    break;
                                case '-':
                                    result.add(left - right);
                                    break;
                                case '*':
                                    result.add(left * right);
                                    break;
                            }
                        }
                    }
                }
            }

            // If no operators were found (single number case)
            if (result.isEmpty()) {
                result.add(Integer.parseInt(input));
            }

            memo.put(input, result);
            return result;
        }

}
