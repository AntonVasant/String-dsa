package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubSet {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] max = new int[26];
        for (String s : words2){
            char[] arr = new char[26];
            for (char  c : s.toCharArray())
                max[c-'a'] = Math.max(arr[c-'a']++,max[c-'a']);
        }
        List<String> list = new ArrayList<>();
        for (String s : words1){
            char[] arr2 = new char[26];
            for (char c : s.toCharArray())
                arr2[c - 'a']++;
            boolean flag = true;
            for (int i = 0; i < 26; i++){
                if (max[i] > arr2[i]){
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(s);
        }
        return list;
    }
}
