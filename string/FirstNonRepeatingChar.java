package string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public char nonRepeating(String str){
        Map<Character,Integer>map = new HashMap<>();
        char[] array = str.toCharArray();
        for(char c : array)
            map.put(c,map.getOrDefault(c,0)+1);
        for (char c: array) {
            if (map.get(c) == 1)
                return c;
        }
        return '\0';
    }
}
