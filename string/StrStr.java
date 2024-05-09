package string;

public class StrStr {
    public int strStr(String hayStack,String needle){
        if(needle.isEmpty())
            return 0;

        for(int i=0;i<=hayStack.length()-needle.length();i++){
            if(hayStack.substring(i,i+needle.length()).equals(needle))
                return i;
        }
        return -1;
    }
}
