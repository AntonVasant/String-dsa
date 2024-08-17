package greedy;

public class MaximumNumberAfterSwap {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10]; // To store the last occurrence of each digit

        // Fill the last occurrence array
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        // Traverse the number and check for a possible swap
        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Found a larger digit later, swap them
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    // Return the result after the swap
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num; // Return the original number if no swap improves it
    }
}
