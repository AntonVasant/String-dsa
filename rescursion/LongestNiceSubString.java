package rescursion;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubString {
    public String longestNiceSubstring(String s) {
        int[] ans = helper(s,0,s.length());
        return s.substring(ans[0],ans[1]);
    }

    private int[] helper(String s,int start,int end){
        Set<Character> set = getCharacters(s,start,end);
        for (int i = start; i < end; i++){
            if (!set.contains(Character.toLowerCase(s.charAt(i))) || !set.contains(Character.toUpperCase(s.charAt(i)))){
                int[] prefix = helper(s,start,i);
                int[] suffix = helper(s,i+1,end);
                if (prefix[1] - prefix[0] > suffix[1] - suffix[0])
                    return prefix;
                else return suffix;
            }
        }
        return new int[]{start,end};
    }

    private Set<Character> getCharacters(String s,int start,int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++){
            set.add(s.charAt(i));
        }
        return set;
    }
}
