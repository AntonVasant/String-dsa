package greedy;

public class MinimumDeletionToLexicographic {
    public int minDeletionSize(String[] strs) {
        int cur = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        int count = 0;
        for (int i = 1; i < strs.length; i++){
            while (pointer1 < strs[cur].length() && pointer2 < strs[i].length()){
                if (strs[cur].charAt(pointer1) < strs[i].charAt(pointer2)){
                    break;
                }
                count++;
                pointer1++;
                pointer2++;
            }
            cur = i;
            pointer2 = 0;
            pointer1 = 0;
            if (count == strs[0].length()) return count;
        }
        return count;
    }
}
