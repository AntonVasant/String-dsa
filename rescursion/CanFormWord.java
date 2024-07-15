package rescursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CanFormWord {
    public static void canForm(String s, Set<String> words){
        Map<String,Boolean> map = new HashMap<>();
        boolean b = helper(map,words,s);
        System.out.println(b);
    }

    private static boolean helper(Map<String,Boolean> map,Set<String> set,String s){
        if (map.containsKey(s))
            return map.get(s);
        if (s.isEmpty())
            return true;
        for (int i = 1; i <= s.length(); i++){
            String prefix = s.substring(0,i);
            String suffix = s.substring(i);
            if (set.contains(prefix)){
                if (helper(map, set, suffix)){
                    map.put(prefix,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }
}
