package string;

public class BinaryToDecimal {
    public int binary(String str){
        int result=0;
        for (int i=0;i<str.length();i++){
            char current = str.charAt(i);
            if (current=='1')
                result+=(int)Math.pow(2,str.length()-i-1);
        }
        return result;
    }
}
