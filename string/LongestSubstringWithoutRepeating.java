package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public String subString(String str){
        Map<Character,Integer> map = new HashMap<>();
        int start=0;
        int maxLength=0;
        int maxStart=0;
        for(int end=0;end<str.length();end++){
            char current = str.charAt(end);
            if(map.containsKey(current)){
                start = Math.max(start,end);
            }
            map.put(current,end);
            if(end-start+1>maxLength){
                maxLength = end-start+1;
                maxStart=start;
            }
        }
        return str.substring(maxStart,maxStart+maxLength);
    }
}
