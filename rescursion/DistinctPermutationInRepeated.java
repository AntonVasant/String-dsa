package rescursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistinctPermutationInRepeated {
    public static void permutation(String str){
        int n = str.length();
        char[] array = str.toCharArray();
        boolean[] used = new boolean[n];
        List<String> list = new ArrayList<>();
        helper(str,new ArrayList<>(),list,used,array,0);
        list.forEach(System.out::println);

    }

    private static void helper(String s, List<Character> list, List<String> result,boolean[] used,char[] charArray,int index){
        if (index == charArray.length){
            if (list.size() == charArray.length){
                StringBuilder sb  = new StringBuilder();
                for (char c : list){
                    sb.append(c);
                }
                result.add(sb.toString());
            }
        }

        for (int i = 0 ; i < charArray.length; i++){
            if (used[i]) continue;
            if (i > 0 && charArray[i] == charArray[i-1] && !used[i-1]) continue;
            if (!used[i]){
                used[i] = true;
                list.add(charArray[i]);
                helper(s, list, result, used, charArray, i+1);
            }
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}
