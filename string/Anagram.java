package string;

import javax.lang.model.util.AbstractElementVisitor14;
import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String str1,String str2){
        if(str1.length() != str2.length())
            return false;
        char[] c1= str1.toCharArray();
        char[] c2 = str2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }
}
