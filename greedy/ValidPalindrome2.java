package greedy;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            else {
                if (isPalindrome(left+1,right,s)) return true;
                if (isPalindrome(left,right-1,s)) return true;
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(int i,int j, String s){
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
