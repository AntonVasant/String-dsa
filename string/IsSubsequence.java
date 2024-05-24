package string;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int left = 0;
        int right = 0;
        int len = s.length();
        int n = t.length();
        while (right < n && left < len) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == len;
    }
}
