package string;

public class RLEEncoding {
    public String encoding(String str){
        int count=1;
        char ch;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<str.length();i++){
            ch = str.charAt(i);
            if(str.charAt(i)!=str.charAt(i-1)){
                sb.append(count);
                sb.append(str.charAt(i-1));
                count=1;
            }
            count++;
        }
        return sb.toString();
    }
}
