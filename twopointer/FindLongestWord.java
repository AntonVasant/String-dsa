package twopointer;

import java.util.Collections;
import java.util.List;

public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            if (a.length() != b.length())
                return b.length() - a.length();
            else return a.compareTo(b);
        });
        for (String str : dictionary){
            if (isSubsequence(str,s))
                return str;
        }
        return "";
    }

    private boolean isSubsequence(String s,String s1){
        int n1 = s.length();
        int n2 = s1.length();
        int i = 0, j = 0;
        while (i < n1 && j < n2){
            if (s.charAt(i) == s1.charAt(j)){
                i++;
            }
            j++;
        }
        return i >= n1;
    }
}
