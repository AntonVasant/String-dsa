package dp;


public class IntegerReplacement {
    public int integerReplacement(int n) {
        return helper((long) n);
    }

    private int helper(long n) {
        if (n == 1) return 0;

        if (n == 3) return 2;

        if (n % 2 == 0)
            return 1 + helper(n / 2);
        else
            return 1 + Math.min(helper(n + 1), helper(n - 1));
    }
}
