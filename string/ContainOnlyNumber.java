package string;

public class ContainOnlyNumber {
    public boolean isNumber(String str){
        char ch;
        for(int i=0;i<str.length();i++){
            ch = str.charAt(i);
            if(!Character.isDigit(ch))
                return false;
        }
        return true;
    }
}
