package string;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        int left = 0;
        int n = s.length();
        int right = n-1;
        char[] arr = s.toCharArray();
        while (left < right){
            while (left < right && !Character.isLetter(s.charAt(left)))
                left++;
            while (right > left && !Character.isLetter(s.charAt(right)))
                right--;
            char emp = arr[left];
            arr[left] = arr[right];
            arr[right] = emp;
            right--;
            left++;
        }
        return new String(arr);
    }
}
