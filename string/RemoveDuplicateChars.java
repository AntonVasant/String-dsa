package string;

import java.util.*;

public class RemoveDuplicateChars {
    public String removeDuplicateLetters(String s) {
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        for (char c : s.toCharArray()){
            map.put(c,map.get(c)-1);
            if (set.contains(c)) continue;

            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 0)
                set.remove(stack.pop());
            set.add(c);
            stack.push(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char  c : stack){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
