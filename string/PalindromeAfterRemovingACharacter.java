package string;

public class PalindromeAfterRemovingACharacter {
    public boolean isPalindrome(String str){
        int start=0;
        int end=str.length()-1;
        while(start<=end){
            if(str.charAt(start)!=str.charAt(end))
                return palindrome(str,start+1,end)|| palindrome(str,start,end-1);
            start++;
            end--;
        }
        return true;
    }
    private boolean palindrome(String str,int start,int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
