package rescursion;

import java.util.*;

public class WordBreak2 {
    public static void word(String s,Set<String> set){
       List<String> list = helper(new HashMap<>(),s,set);
        list.forEach(System.out::println);
    }

    private static List<String> helper(Map<String, List<String>> map, String s, Set<String> set) {
        // Check if the result for the current substring 's' is already in the memo map
        if (map.containsKey(s)) {
            return map.get(s);
        }

        // List to store the results for the current substring 's'
        List<String> list = new ArrayList<>();

        // Base case: if 's' is empty, add an empty string to the list and return
        if (s.isEmpty()) {
            list.add("");
            return list;
        }

        // Iterate through each word in the set (word dictionary)
        for (String str : set) {
            // Check if the current substring 's' starts with the dictionary word 'str'
            if (s.startsWith(str)) {
                // Recursively call helper on the remaining substring after removing 'str' from the start
                List<String> subList = helper(map, s.substring(str.length()), set);

                // Combine the current word 'str' with each result from the recursive call
                for (String sub : subList) {
                    // Add the combined result to the list
                    list.add(str + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }

        // Store the result for the current substring 's' in the memo map
        map.put(s, list);
        return list;
    }
}
