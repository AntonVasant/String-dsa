package twopointer;

import java.util.Arrays;

public class PermutationInString {
    public static boolean isPermutation(String s1,String s2){
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int s1Length = s1.length();
        int s2Length = s2.length();
        for (int i = 0; i < s1Length; i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(freq1,freq2)) return true;
        for (int i = s1Length; i < s2Length; i++){
            freq2[s2.charAt(i) -'a']++;
            freq2[s2.charAt(i-s1Length) -'a']--;

            if (Arrays.equals(freq1,freq2)) return true;
        }
        return false;
    }
}
