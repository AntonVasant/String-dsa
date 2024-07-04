package twopointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(s.isEmpty() || t.isEmpty() || sLen < tLen) return "";
        Map<Character,Integer> targetFreq = new HashMap<>();
        for(int i = 0; i < tLen; i++)
            targetFreq.put(t.charAt(i),targetFreq.getOrDefault(t.charAt(i),0)+1);
        int right = 0;
        int left = 0;
        int maxLength = Integer.MAX_VALUE;
        int start = 0;
        int found = 0;
        int required = targetFreq.size();
        Map<Character,Integer> map = new HashMap<>();
        while(right < sLen){
            char current = s.charAt(right);
            map.put(current,map.getOrDefault(current,0)+1);

            if(targetFreq.containsKey(current) &&
                    targetFreq.get(current).intValue() == map.get(current).intValue()){
                found++;
            }
            while(left <= right && found == required){
                char leftChar = s.charAt(left);
                if((right - left + 1) < maxLength){
                    maxLength = right - left + 1;
                    start = left;
                }
                map.put(leftChar,map.get(leftChar)-1);
                if (targetFreq.containsKey(leftChar) && map.get(leftChar).intValue() < targetFreq.get(leftChar).intValue()) {
                    found--;
                }
                left++;
            }
            right++;
        }
        return maxLength == Integer.MAX_VALUE ? "" : s.substring(start,start + maxLength);
    }
}
