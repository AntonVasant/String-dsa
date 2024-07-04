package rescursion;

import java.util.ArrayList;
import java.util.List;

public class IPV6 {
    public static void ip(String str){
        List<String> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        helper(str,0,list,ans);
        for (String s : ans)
            System.out.println(s);
    }

    private static void helper(String str,int index,List<String> list,List<String> ans){
        if (index == str.length() && list.size() == 8){
            ans.add(String.join(":",list));
            return;
        }
        if (index == str.length() || list.size() == 8) return;
        for (int i = index; i < str.length() && i < index + 4; i++){
            String s = str.substring(index,i+1);
            if (validate(str)){
                list.add(s);
                helper(str, i+1, list,ans);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean validate(String str){
        if (str.length() > 4) return false;
        for (char c : str.toCharArray()){
            if (!Character.isDigit(c) && "abdcefABCDEF".contains(String.valueOf(c)))
                return false;
        }
        return true;
    }

}
