package twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumFreqOfSubString {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int left = 0;
        int right = minSize;
        Map<String,Integer> map = new HashMap<>();
        while (right <= s.length()){
            String sub = s.substring(left,right);
            map.put(sub,map.getOrDefault(sub,0)+1);
            left++;
            right++;
        }
        int max = 0;
        for (String str : map.keySet()){
            int n = map.get(str);
            if (n > max && isValid(str,maxLetters)){
                max = n;
            }
        }
        return max;
    }

    private boolean isValid(String str,int count){
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()){
            set.add(c);
        }
        return set.size() <= count;
    }
}
