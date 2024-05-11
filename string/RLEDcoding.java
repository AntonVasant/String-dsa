package string;

import com.sun.source.tree.BreakTree;

public class RLEDcoding {
    public String decode(String str){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length();i++){
            if(isNumber(str.charAt(i))){
                int number=Character.getNumericValue(str.charAt(i));
                for(int j=0;j<number;j++){
                    sb.append(str.charAt(i+1));
                }
                i++;
            }else sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    private boolean isNumber(char c){
        return Character.isDigit(c);
    }

}
