package rescursion;

import java.util.ArrayList;
import java.util.List;

public class IPv4 {
    public void iPv4(String s){
        List<String> list = new ArrayList<>();
        helper(s,new ArrayList<>(),0,list);
        for (String st : list){
            System.out.println(st+" ");
        }
    }
    private void helper(String s,List<String> current,int index,List<String> ans){
        if(current.size() == 4 && index == s.length()){
            ans.add(String.join(".",current));
            return;
        }
        if(current.size() == 4 || index == s.length()) return;
        for (int i = index; i < s.length() && i < index+3; i++){
                String str = s.substring(index,i+1);
                if (validate(str)){
                    current.add(str);
                    helper(s,current,i+1,ans);
                    current.remove(current.size()-1);
                }

        }
    }
    private boolean validate(String s){
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

}
