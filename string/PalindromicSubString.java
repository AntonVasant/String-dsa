package string;

public class PalindromicSubString {
    public static int subString(String str){
        int n = str.length();
        int count = 0;
        for (int i = 0; i < n; i++){
            count += palindrome(str,i,i);
            count += palindrome(str,i,i+1);
        }
        return count;
    }

    private static int palindrome(String str,int left,int right){
        int n = str.length();
        int count = 0;
        while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)){
            count++;
            right++;
            left--;
        }
        return count;
    }
}
