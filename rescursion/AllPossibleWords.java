package rescursion;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleWords {
    public static void words(String number){
       List<String> ls = new ArrayList<>();
        helper(number,0,ls,"");
        for (String s : ls)
            System.out.println(s);

    }

    private static void helper(String string, int index, List<String> list,String str){
        if (index == string.length()){
            list.add(str);
            return;
        }

        for (int i = 1; i <= 2 && index+i <= string.length(); i++){
            String s = string.substring(index,index+i);
            int num = Integer.parseInt(s);
            if (num > 0 && num <= 26){
                 char c = (char) ('A'+ num-1);
                 helper(string, index+i, list, str+c);
            }
        }
    }
}
