package incomplete;


public class ShortPalindrome {
    public String shortestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) return s;
        String reverse = new StringBuilder(s).reverse().toString();
        String combine = s +"#"+reverse;
        int[] table = helper(combine);
        String sub = reverse.substring(0, reverse.length() - table[table.length-1]);
        return sub + s;
    }

    private int[] helper(String s){
        int n = s.length();
        int[] ans = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++){
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = ans[j-1];
            if (s.charAt(i) == s.charAt(j))
                j++;
            ans[i]  = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        ShortPalindrome palindrome = new ShortPalindrome();
        System.out.println(palindrome.shortestPalindrome("aaacecaaa"));
    }
}
