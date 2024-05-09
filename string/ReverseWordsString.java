package string;

public class ReverseWordsString {
    public String reverse(String str){
        StringBuffer sb = new StringBuffer();
        String[] array = str.split(" ");
        rev(array);
        for(String s : array){
            sb.append(s+" ");
        }
        return sb.toString().trim();
    }
    public static String[] rev(String[] str){
        int first=0;
        int last= str.length-1;
        String temp;
        while (first<= last){
            temp = str[first];
            str[first]= str[last];
            str[last] = temp;
            first++;
            last--;
        }
        return str;
    }
}
