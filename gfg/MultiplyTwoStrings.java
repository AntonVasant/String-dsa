package gfg;

import java.util.Arrays;

public class MultiplyTwoStrings {

    public static String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[m+n];
        for (int i = n-1; i >= 0; i--){
            for (int j = m-1;j >= 0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + result[j+i+1];
                result[i+j+1] = mul % 10;
                result[i+j] += mul /10;
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(result));
        for (int j : result) {
            if (sb.isEmpty() && j == 0) continue;
            sb.append(j);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
