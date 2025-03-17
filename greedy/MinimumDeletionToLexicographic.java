package greedy;

public class MinimumDeletionToLexicographic {
    public int minDeletionSize(String[] arr) {
        int cur = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        int count = 0;
        for (int i = 1; i < arr.length; i++){
            while (pointer1 < arr[cur].length() && pointer2 < arr[i].length()){
                if (arr[cur].charAt(pointer1) < arr[i].charAt(pointer2)){
                    break;
                }
                count++;
                pointer1++;
                pointer2++;
            }
            cur = i;
            pointer2 = 0;
            pointer1 = 0;
            if (count == arr[0].length()) return count;
        }
        return count;
    }
}
