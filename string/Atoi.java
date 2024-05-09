package string;

public class Atoi {
    public int atio(String str){
        int result=0;
        int res;
        char current;
        for(int i=0;i<str.length();i++){
            current=str.charAt(i);
            if(!Character.isDigit(current))
                return -1;
            res = current-'0';
            result+=result*10+res;
        }
        return result;
    }
}
