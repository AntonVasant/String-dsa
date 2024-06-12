package dp;

import string.Reverse;

public class NumberOfInsertionDeletionPalindrome {
    public static int insertion(String str){
        String str2 = Reverse.reverse(str);
        int len  = str.length();
        int[][] dp = new int[len+1][len+1];
        return len - LongestPalindromicSubSequence.longestPalindromicSubSequence(str);
    }

}
