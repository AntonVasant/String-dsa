package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//
public class ConcatenationAllString {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> wordMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int wordLength = words[0].length();
        for (String str : words){
            wordMap.put(str,wordMap.getOrDefault(str,0)+1);
        }
        int count = words.length;
        for (int i = 0; i < wordLength; i++){
            int left = i;
            int right = i;
            int currentCount = 0;
            Map<String,Integer> currentMap = new HashMap<>();
            while (right+wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (wordMap.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    currentCount++;

                    while (currentMap.get(word) > wordMap.get(word)) {
                        String remove = s.substring(left, left + wordLength);
                        currentMap.put(remove, currentMap.getOrDefault(remove, 0) - 1);
                        currentCount--;
                        left += wordLength;
                    }
                    if (currentCount == count) {
                        list.add(left);
                    }
                }else {
                    currentCount = 0;
                    currentMap.clear();
                    left = right;
                }
            }

        }
        return list;
    }
}
