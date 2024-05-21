package string;

import java.util.HashMap;
import java.util.Map;

public class FindSubstringBetweenIndex {
    public String subString(String str1,String str2){
        int min=Integer.MAX_VALUE;
        int max=0;
        Map<Character,Integer> map = new HashMap<>();
        for (char c : str2.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        for (int i=0;i<str1.length();i++){
            char current = str1.charAt(i);
            if (map.containsKey(current)){
                map.put(current,map.get(current)-1);
                if (map.get(current)==0){
                    map.remove(current);
                }

                min = Math.min(min,i);
                max=Math.max(max,i);
                if (map.isEmpty())
                    break;
            }
        }
        return str1.substring(min,max+1);
    }
}
