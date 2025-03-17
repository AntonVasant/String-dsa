package string;

import java.util.Arrays;
import java.util.HashSet;

public class LongestLexicoAndPrefixString {
    public static String longestString(int n, String[] arr) {
        Arrays.sort(arr);
        HashSet<String> prefixSet = new HashSet<>();
        String longest = "";
        for (String str : arr) {
            boolean allPrefixesPresent = true;
            for (int i = 1; i < str.length(); i++) {
                String prefix = str.substring(0, i);
                if (!prefixSet.contains(prefix)) {
                    allPrefixesPresent = false;
                    break;
                }
            }
            if (allPrefixesPresent) {
                prefixSet.add(str);
                if (str.length() > longest.length()) {
                    longest = str;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestString(3, new String[]{"a", "ab", "abc", "abd"}));
    }
}
/*
all prefix string should be there in arr and return the lexico smallest and longest string
 */
