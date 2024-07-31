package string;

import java.util.List;

public class Main {
    public static void main(String a[]){
        SubstrinWithAtleastkRepeatingChar substrin = new SubstrinWithAtleastkRepeatingChar();
        int n = substrin.longestSubstring("aaabb",3);
        System.out.println(n);
    }
}
