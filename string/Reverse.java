package string;
public class Reverse {
    public String reverse(String str){
        if(str == null || str.isEmpty())
            return"";
        int start =0;
        int end = str.length()-1;
        char[] c = str.toCharArray();
        char temp;
        while(start <= end){
            temp= c[start];
            c[start] = c[end];
            c[end]=temp;
            start++;
            end--;
        }
        StringBuffer sb = new StringBuffer();
        for(char ch : c){
            sb.append(ch);
        }
        return sb.toString();
    }
}
