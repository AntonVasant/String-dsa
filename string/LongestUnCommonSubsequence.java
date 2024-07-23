package string;

import graph.SurroundedRegion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestUnCommonSubsequence {
    public int findLUSlength(String[] strs) {
        Set<String> visited = new HashSet<>();
        Set<String> duplicate  = new HashSet<>();
        for (String s : strs){
            if (visited.contains(s)){
                duplicate.add(s);
            }
            visited.add(s);
        }
        Arrays.sort(strs,(a,b) -> b.length() - a.length());
        for (int i = 0; i < strs.length; i++){
            if (duplicate.contains(strs[i])) continue;
            boolean unCommon = true;
            for (int j = 0; j < strs.length; j++){
                if (j != i && !isSubSequence(strs[i],strs[j])){
                    unCommon = false;
                    break;
                }
            }
            if (unCommon) return strs[i].length();
        }
        return -1;
    }

    private boolean isSubSequence(String s1,String s2){
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s1.length();
    }
}
