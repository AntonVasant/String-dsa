package string;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<String,Character> stringchar = new HashMap<>();
        Map<Character,String> charString = new HashMap<>();
        String[] arr = s.split("\\s+");
        for (int i = 0; i < arr.length; i++){
            char c = pattern.charAt(i);
            if (charString.containsKey(c))
                if (!charString.get(c).equals(arr[i]))
                    return false;
            else {
                    if (stringchar.containsKey(arr[i])) return false;
                    charString.put(c,arr[i]);
                    stringchar.put(arr[i],c);
                }
        }
        return true;
    }
}
