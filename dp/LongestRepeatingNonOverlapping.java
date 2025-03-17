package dp;

import java.util.Arrays;

public class LongestRepeatingNonOverlapping {
    static String longestSubstring(String s, int N) {
        int[][] LCSRe = new int[N + 1][N + 1];

        // Setting all to 0
        for (int[] row : LCSRe) {
            Arrays.fill(row, 0);
        }

        StringBuilder res = new StringBuilder(); // To store result
        int res_length = 0; // To store length of result
        int index = 0; // To store the starting index of the longest substring

        // building table in bottom-up manner
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                // (j-i) > LCSRe[i-1][j-1] to remove
                // overlapping
                if (s.charAt(i - 1) == s.charAt(j - 1) &&
                        LCSRe[i - 1][j - 1] < (j - i)) {
                    LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1;

                    // updating maximum length of the
                    // substring and updating the starting
                    // index of the longest substring
                    if (LCSRe[i][j] > res_length) {
                        res_length = LCSRe[i][j];
                        index = Math.max(i, index);
                    }
                } else {
                    LCSRe[i][j] = 0;
                }
            }
        }

        // If we have non-empty result, then insert all
        // characters from the starting index to the
        // length of the longest substring
        if (res_length > 0) {
            for (int i = index - res_length + 1; i <= index; i++) {
                res.append(s.charAt(i - 1));
            }
        } else {
            res.append("-1");
        }

        return res.toString();
    }
}
