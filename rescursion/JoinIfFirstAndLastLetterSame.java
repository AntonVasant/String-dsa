package rescursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoinIfFirstAndLastLetterSame {


       public static int findMaxCombinedLength(String[] arr, int n){
           Map<Character, List<String>> listMap = new HashMap<>();
           for (String s : arr){
               char c = s.charAt(0);
               listMap.putIfAbsent(c, new ArrayList<>());
               listMap.get(c).add(s);
           }

           Map<String , Boolean> visited = new HashMap<>();
           int maxLength = 0;
           for (String s : arr){
               maxLength = Math.max(maxLength, dfs(listMap,visited,s));
           }
           return maxLength;
       }

       private static int dfs(Map<Character, List<String>> map, Map<String, Boolean> visited, String current){
           visited.put(current, true);
           int length = current.length();
           char last = current.charAt(current.length()-1);
           if (map.containsKey(last)){
               for (String s : map.get(last)){
                   if (!visited.getOrDefault(s, false))
                        length = Math.max(length,current.length() + dfs(map,visited,s));
               }
           }
           visited.put(current, false);
           return length;
       }

        public static void main(String[] args) {
            String[] s = {"RBR", "BBR", "RRR"};
            int n = s.length;
            System.out.println(findMaxCombinedLength(s, n));  // Output: 9
        }

}
