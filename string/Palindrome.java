package string;

public class Palindrome {
    public boolean isPalindrome(String str){
        int start =0;
        int end = str.length()-1;
        char ch;
        while(start <= end){
             if(str.charAt(start)!=str.charAt(end))
                 return false;
             start++;
             end--;
        }
        return true;
    }
}
