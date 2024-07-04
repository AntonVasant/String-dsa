package rescursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutations {
    public static void permutations(String str){
        boolean[] flag = new boolean[str.length()];
        Set<String> list = new HashSet<>();
        helper(list,str,flag,0,new StringBuilder());
        for (String s : list)
            System.out.println(s);

    }

    private static void helper(Set<String> list,String str,boolean[] flag,int index, StringBuilder sb){
        if (index == str.length()) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++){
            if (!flag[i]){
                flag[i] = true;
                sb.append(str.charAt(i));
                helper(list, str, flag, index+1, sb);
                flag[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
