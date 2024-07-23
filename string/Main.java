package string;

import java.util.List;

public class Main {
    public static void main(String a[]){
        ReverseAllWords reverseAllWords = new ReverseAllWords();
        String s = reverseAllWords.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }
}
