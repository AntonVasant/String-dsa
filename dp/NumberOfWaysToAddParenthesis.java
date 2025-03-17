package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfWaysToAddParenthesis {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return compute(input, memo);
    }

    private List<Integer> compute(String input, Map<String, List<Integer>> memo) {
        if (memo.containsKey(input)) {
            return memo.get(input);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // Divide the input into two parts and solve recursively
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);

                List<Integer> part1Results = compute(part1, memo);
                List<Integer> part2Results = compute(part2, memo);

                // Combine the results from the two parts
                for (int r1 : part1Results) {
                    for (int r2 : part2Results) {
                        int combinedResult = switch (c) {
                            case '+' -> r1 + r2;
                            case '-' -> r1 - r2;
                            case '*' -> r1 * r2;
                            default -> 0;
                        };
                        result.add(combinedResult);
                    }
                }
            }
        }

        // If there were no operators, the input is a single number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }

        memo.put(input, result);
        return result;
    }
}
