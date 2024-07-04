package twopointer;

public class LongestCharacterReplacement {
        public int characterReplacement(String s, int k) {
            int[] hash = new int[26];
            int maximum = 0;
            int length = 0;
            int left = 0;
            for(int right = 0; right < s.length(); right++){
                hash[s.charAt(right)- 'A']++;
                maximum = Math.max(maximum,hash[s.charAt(right) - 'A']);
                if (((right-left+1) - maximum) > k){
                    hash[s.charAt(left) - 'A']--;
                    left++;
                }
                length = Math.max(length,right-left+1);
            }
            return length;
        }
}
