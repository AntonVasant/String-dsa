package string;

public class MergeStringAlternative {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < word1.length() && j < word2.length()){
            ans.append(word1.charAt(i));
            i++;
            ans.append(word2.charAt(j));
            j++;
        }
        if (i < word1.length()){
            for (int s = i; s < word1.length(); s++)
                ans.append(word1.charAt(s));
        }
        if (j < word2.length()){
            for (int s = j; s < word1.length(); s++)
                ans.append(word2.charAt(s));
        }
        return ans.toString();
    }
}
