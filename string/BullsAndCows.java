package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : secret.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++){
            char g = guess.charAt(i);
            char sec = secret.charAt(i);
            if (g == sec){
                bulls++;
                map.put(g,map.get(g)-1);
                if (map.get(g) == 0)
                    map.remove(g);
            }
        }

        for (int i = 0; i < guess.length(); i++){
            char g = guess.charAt(i);
            char sec = secret.charAt(i);
            if (g != sec && map.containsKey(g)){
                cows++;
                map.put(g,map.get(g)-1);
                if (map.get(g) == 0)
                    map.remove(g);
            }
        }
        String s = bulls+"A"+cows+"B";
        return s;
    }
}
