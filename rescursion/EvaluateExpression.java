package rescursion;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpression {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        helper(list, "", num, target, 0, 0, 0);
        return list;
    }

    private void helper(List<String> list, String res, String num, int target, int index, long evaluation, long multiplied) {
        // Base case: if we've reached the end of the string
        if (index == num.length()) {
            if (evaluation == target) {
                list.add(res);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;
            long number = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                helper(list, res + number, num, target, i + 1, number, number);
            } else {
                helper(list, res + "+" + number, num, target, i + 1, evaluation + number, number);
                helper(list, res + "-" + number, num, target, i + 1, evaluation - number, -number);
                helper(list, res + "*" + number, num, target, i + 1, evaluation - multiplied + multiplied * number, multiplied * number);
            }
        }
    }
}
