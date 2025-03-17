package string;

public class ReverseStringExceptSpecialChar {
    public String reverse(String str){
        int left=0;
        int right=str.length()-1;
        char[] chars = str.toCharArray();
        while(left < right){
            if(!isSpecialChar(chars[left])){
                while(right > left && isSpecialChar(chars[right]))
                    right--;
                char temp=chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
            }
            left++;
        }
       return new String(chars);
    }
    public static boolean isSpecialChar(char c){
        return !Character.isLetterOrDigit(c);
    }
}
