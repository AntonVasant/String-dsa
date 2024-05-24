package string;

public class SentPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            // Skip non-alphanumeric characters at the start
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            // Skip non-alphanumeric characters at the end
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            // Compare characters
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}
