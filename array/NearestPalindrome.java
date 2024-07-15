package array;

public class NearestPalindrome {

    public static void palindrome(int num){
        String s = String.valueOf(num);
        int n = s.length();
        if (isAll9(s)){
            System.out.println(num+2);
            return;
        }
        String left = s.substring(0,n/2+1);
        String mirror = mirror(left,n%2 == 0);
        String newStr = left + mirror;
        if (Integer.parseInt(newStr) > num){
            System.out.println(newStr);
        }else {
            System.out.println("no palindrome");
        }
    }

    private static String mirror(String s,boolean even){
        StringBuilder sb = new StringBuilder(s);
        if (even){
            return sb.reverse().toString();
        }else return sb.reverse().substring(1);
    }

    private static boolean isAll9(String s){
        for (char c : s.toCharArray()){
            if (c != '9')
                return false;
        }
        return true;
    }
}
