package math;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder result = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0))
            result.append("-");
        Long num =  Math.abs((long)numerator);
        Long den =  Math.abs((long)denominator);
        result.append(num/den);
        Long remainder =  (num % den);
        if (remainder == 0)
            return result.toString();

        result.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while (remainder != 0){
            if (map.containsKey(remainder)){
                int start = map.get(remainder);
                result.insert(start,"(");
                result.append(")");
                return result.toString();
            }
            map.put(remainder,result.length());
            remainder *= 10;
            result.append(remainder/den);
            remainder %= den;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(FractionToDecimal.fractionToDecimal(-1,-2147483648));
    }
}
