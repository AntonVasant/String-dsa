package dp;

import java.util.HashMap;
import java.util.Map;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        Map<String, Boolean> memo = new HashMap<>();
        return dp(s, p, 0, 0, memo);
    }
    private boolean dp(String s, String p, int i, int j, Map<String, Boolean> memo) {
        if (memo.containsKey(i + "-" + j)) {
            return memo.get(i + "-" + j);
        }
        boolean result;
        if (j == p.length()) {
            result = i == s.length(); // Pattern is exhausted
        } else {
            boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                result = dp(s, p, i, j + 2, memo) || (firstMatch && dp(s, p, i + 1, j, memo));
            } else {
                result = firstMatch && dp(s, p, i + 1, j + 1, memo);
            }
        }

        memo.put(i + "-" + j, result);
        return result;
    }
}
