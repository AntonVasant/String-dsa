package greedy;

import java.util.*;

public class SmallestSubOfDistinctChars {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] visit = new boolean[26];
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr){
            freq[c-'a']++;
        }
        for (char  c : arr){
            freq[c - 'a']--;
            if (visit[c-'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek()- 'a'] > 0){
                visit[stack.pop()-'a'] = false;
            }
            stack.push(c);
            visit[c-'a'] = true;
        }
        StringBuilder sbb = new StringBuilder();
        for (char c : stack)
            sbb.append(c);
        return sbb.toString();
    }
}
