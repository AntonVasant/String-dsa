package string;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombination {
    private static final String[] KEYPAD_MAPPING = {
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> combinations(String str){
        List<String> list = new ArrayList<>();
        if(str.isEmpty())
            return list;
        combinationHelper(list,new StringBuilder(),str,0);
        return list;
    }
    private void combinationHelper(List<String> list,StringBuilder sb,String str,int index){
        if(index == str.length()){
            list.add(sb.toString());
            return ;
        }
        String current = KEYPAD_MAPPING[str.charAt(index)-'0'];
        for (char c : current.toCharArray()){
            sb.append(c);
            combinationHelper(list,sb,str,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
