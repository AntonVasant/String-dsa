package dp;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
    public boolean isScramble(String s1, String s2) {
        Map<String,Boolean> map = new HashMap<>();
        return helper(map,s1,s2);
    }

    private boolean helper(Map<String,Boolean> map ,String s1,String s2){
        String key = s1 + "$" + s2;
        if (map.containsKey(key))
            return map.get(key);
        if(s1.equals(s2))
        {
            map.put(key,true);
            return true;
        }

        int n = s1.length();

        for (int i = 1; i < n; i++){
            if (helper(map,s1.substring(0,i),s2.substring(0,i))
                    && helper(map,s1.substring(i),s2.substring(i))){
                map.put(key,true);
                return true;
            }
            if (helper(map,s1.substring(0,i),s2.substring(n-i))
                    && helper(map,s1.substring(i),s2.substring(0,n-i))){
                map.put(key,true);
                return true;
            }
        }
        map.put(key,false);
        return false;
    }
}
