package string;

public class SubstrinWithAtleastkRepeatingChar {
        public int longestSubstring(String s, int k) {
            return longestSubstringHelper(s, k, 0, s.length());
        }

        private int longestSubstringHelper(String s,int k ,int start,int end){
            if (end-start < k) return 0;
            int[] freq = new int[26];
            for (int i = start; i < end;i++)
                freq[s.charAt(i) - 'a']++;
            for (int i = start; i < end; i++){
                if (freq[s.charAt(i) - 'a'] < k){
                    int left = longestSubstringHelper(s,k,start,i);
                    int right = longestSubstringHelper(s,k,i+1,end);
                    return Math.max(left,right);
                }
            }
            return end - start;
        }
}
