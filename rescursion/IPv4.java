package rescursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IPv4 {
    public void iPv4(String s){
        List<String> list = new ArrayList<>();
        helper(s,new ArrayList<>(),0,list);
        for (String st : list){
            System.out.println(st+" ");
        }
    }
    private void helper(String s,List<String> current,int index,List<String> ans){
        if(current.size() == 4 && index == s.length()){
            ans.add(String.join(".",current));
            return;
        }
        if(current.size() == 4 || index == s.length()) return;
        for (int i = index; i < s.length() && i < index+3; i++){
                String str = s.substring(index,i+1);
                if (validate(str)){
                    current.add(str);
                    helper(s,current,i+1,ans);
                    current.remove(current.size()-1);
                }

        }
    }
    private boolean validate(String s){
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

    public static int longestCommonSubstring(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;  // Stores the longest common substring length

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        for (int[] arr : dp)
            System.out.println(Arrays.toString(arr));
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("abcde", "abfce")); // Output: 2 ("ab")
        System.out.println(longestCommonSubstring("abcdef", "zcdemf")); // Output: 3 ("cde")
    }

}
