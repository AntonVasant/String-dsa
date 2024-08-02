package string;

import java.util.*;

public class PalindromePair {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            map.put(words[i],i);
        for (int i = 0; i < words.length; i++){
            String current = words[i];
            int len = current.length();
            for (int j = 0; j <= len; j++){
                String left = current.substring(0,j);
                String right = current.substring(j);
                if (isPalindrome(left)){
                    String reversed  = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reversed) && map.get(reversed) != i)
                        list.add(Arrays.asList(map.get(reversed),i));
                }
                if (isPalindrome(right) && j != current.length()){
                    String reverse = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reverse) && map.get(reverse) != i)
                        list.add(Arrays.asList(i,map.get(reverse)));
                }
            }
        }
        return list;
    }
    private boolean isPalindrome(String s){
        int low = 0;
        int high = s.length()-1;
        while (low < high){
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}
