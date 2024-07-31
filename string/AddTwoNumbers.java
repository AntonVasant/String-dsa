package string;

public class AddTwoNumbers {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int carry = 0;
        while (i >= 0 || j >= 0){
            sum = carry;
            if (i >= 0){
                sum += Integer.parseInt(String.valueOf(num1.charAt(i)));
                i--;
            }
            if (j >= 0 ){
                sum += Integer.parseInt(String.valueOf(num2.charAt(j)));
                j--;
            }
            sb.append(sum%10);
            carry = sum/10;
        }
        if (carry > 0) sb.append(carry);
        return sb.toString();
    }
}
