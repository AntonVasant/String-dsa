package rescursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String a[]) {
        EvaluateExpression expression = new EvaluateExpression();
        List<String> list = expression.addOperators("123",6);
        list.forEach(System.out::println);
    }
}