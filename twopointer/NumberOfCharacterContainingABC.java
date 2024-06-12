package twopointer;

import java.util.Arrays;

public class NumberOfCharacterContainingABC {
    public int numberOfSubstrings(String s) {
        int[] hash = new int[3];
        Arrays.fill(hash,-1);
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a'] = i;
            if (hash[0] != -1 && hash[1] != -1 && hash[2] != -1){
                ans += 1 + Math.min(hash[0] ,Math.min(hash[1],hash[2]));
            }
        }
        return ans;
    }
}
