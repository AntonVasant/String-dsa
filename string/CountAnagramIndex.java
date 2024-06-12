package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountAnagramIndex {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char[] array = p.toCharArray();
        Arrays.sort(array);
        String anagram = new String(array);
        int left = 0;
        int right = p.length()-1;
        while(right < s.length()){
            if(check(anagram,left,right,s)){
                list.add(left);
            }
            left++;
            right++;
        }
        return list;
    }
    private boolean check(String anagram,int left,int right,String s){
        char[] array = s.substring(left,right+1).toCharArray();
        Arrays.sort(array);
        String t  = new String(array);
        return anagram.equals(t);
    }
}
