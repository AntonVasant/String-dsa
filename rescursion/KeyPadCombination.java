package rescursion;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCombination {
    static String[] keyPad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.isEmpty()) return list;
        helper(list,digits,0,new StringBuilder());
        return list;
    }

    private static void helper(List<String> ans, String str,int index,StringBuilder sb){
        if(index == str.length()){
            ans.add(sb.toString());
            return;
        }
        String current = keyPad[str.charAt(index) - '0'];
        for(char c : current.toCharArray()){
            sb.append(c);
            helper(ans,str,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
