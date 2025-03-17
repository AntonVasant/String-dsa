package twopointer;

import multithreading.game.Paddle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelConsonants {
    public static void main(String[] args) {
        countOfSubstrings("ieaouqqieaouqq", 1);
    }

    //substrings with all vowels at least once and exactly k non vowels
    public static long countOfSubstrings(String word, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        long a = getCounts(set,word, k);
        long b = getCounts(set,word, k+1);
        System.out.println(a +"  "+b);
        return a - b;
    }

    public static long getCounts(Set<Character> set, String s, int k) {
        long ans = 0;
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int consonants = 0;
        int n = s.length();
        while (i < n){
            char c = s.charAt(i);
            if (set.contains(c))
                map.put(c, map.getOrDefault(c, 0) + 1);
            else consonants++;

            while (map.size() == 5 && consonants >= k) {
                ans += (long)  n - i;
                char left = s.charAt(j);
                if (map.containsKey(left)){
                    map.put(left, map.get(left) - 1);
                    if (map.get(left) == 0)
                        map.remove(left);
                }
                else consonants--;
                j++;
            }
            i++;
        }
        return ans;
    }
}


