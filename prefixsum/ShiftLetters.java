package prefixsum;

public class ShiftLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + shifts[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            long shift = prefix[n] - prefix[i];
            int originalIndex = c - 'a';
            long newIndex = (originalIndex + shift) % 26;
            char newChar = (char) (newIndex + 'a');
            sb.append(newChar);
        }
        return sb.toString();
    }
}
