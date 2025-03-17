package gfg;

public class SumOfTwoNum {
    static String findSum(String X, String Y) {
        int n = X.length();
        int m = Y.length();
        int i = n-1;
        int j = m-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += X.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += Y.charAt(j--) - '0';
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(findSum("  4978842","7693"));
    }
}
