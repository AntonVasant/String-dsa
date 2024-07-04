package string;

public class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        int even=0;
        int odd=0;
        int max;
        for(int i=0;i<s.length();i++){
            odd=valid(s,i,i);
            even=valid(s,i,i+1);
            max = Math.max(odd,even);
            if(max > end-start){
                start = i-(max-1)/2;
                end = i + max / 2;
            }
        }
        return s.substring(start,end+1);
    }
    private int valid(String str,int start,int end){
        while(start >= 0 && end < str.length() && str.charAt(start)==str.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
}
