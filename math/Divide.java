package math;

public class Divide {
    public int divide(int dividend, int divisor) {
            // Special case: overflow
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            // Determine the sign of the result
            boolean negative = (dividend < 0) ^ (divisor < 0);

            // Work with positive values to avoid overflow
            long dividendAbs = Math.abs((long) dividend);
            long divisorAbs = Math.abs((long) divisor);

            int result = 0;
            while (dividendAbs >= divisorAbs) {
                long temp = divisorAbs;
                long multiple = 1;

                while (dividendAbs >= (temp << 1)) {
                    temp <<= 1;
                    multiple <<= 1;
                }

                dividendAbs -= temp;
                result += multiple;
            }

            return negative ? -result : result;
        }
}
