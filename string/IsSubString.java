package string;

public class IsSubString {
    public static boolean isEqual(String str,String str2){
        int n = str2.length();
        for (int i = 0; i <= str.length()-n; i++){
            if(str2.equals(str.substring(i,n+i))) return true;
        }
        return false;
    }
}
