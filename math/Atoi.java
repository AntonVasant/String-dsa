package math;

public class Atoi {
    public int myAtoi(String s) {
        int sign = 1;
        long result = 0;
        int start = 0;
        s = s.trim();
        if (s.isEmpty()) return 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start++;
        }
        else if (s.charAt(0) == '+') {
            start++;
        }
        for (int i = start; i < s.length(); i++){
            char c = s.charAt(i);
            if (!Character.isDigit(c))
                break;
            result = result * 10 + c - '0';
            if (result > Integer.MAX_VALUE)
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)result * sign;
    }
}
