package rescursion;

import array.NearestPalindrome;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String a[]) {
        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("sand");
        set.add("dogs");
        WordBreak2.word("catsanddogs",set);
    }
}