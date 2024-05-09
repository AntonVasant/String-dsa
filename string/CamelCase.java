package string;

public class CamelCase {
    public String toCamelCase(String str){
        boolean isCapital = false;
        char c;
        StringBuffer sb =  new StringBuffer();
        for(int i=0;i<str.length();i++){
            c=str.charAt(i);
            if(c==' '){
                isCapital=true;
            }else {
                if(isCapital){
                    sb.append(Character.toUpperCase(c));
                    isCapital=false;
                }else
                    sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
