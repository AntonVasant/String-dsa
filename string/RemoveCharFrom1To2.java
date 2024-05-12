package string;

import java.util.HashSet;
import java.util.Set;

public class RemoveCharFrom1To2 {
    public String remove(String str1,String str2){
        Set<Character> set = new HashSet<>();
        for (int i=0;i<str2.length();i++){
            set.add(str2.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str1.length();i++){
            if (!set.contains(str1.charAt(i)))
                sb.append(str1.charAt(i));
        }
        return sb.toString();
    }
}
