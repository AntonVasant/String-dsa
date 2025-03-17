package gfg;


import java.util.Arrays;

public class CountInversions {
    private static int mergeAndCount(int[] arr,int left,int right){
        int inversions = 0;
        if (left < right){
            int mid = (left + right)/2;
            inversions += mergeAndCount(arr,left,mid);
            inversions += mergeAndCount(arr,mid +1, right);
            inversions += merge(arr,left,mid,right);
        }
        return inversions;
    }

    private static int merge(int[] arr,int left,int mid, int right){
        int[] leftArray = new int[mid-left+1];
        int[] rightArray = new int[right - mid];
        if (mid - left >= 0) System.arraycopy(arr, left, leftArray, 0, mid - left+1);
        if (right - (mid + 1) >= 0) System.arraycopy(arr, mid + 1, rightArray, 0, right - (mid));
        int i = 0;
        int j = 0;
        int ans = 0;
        int k = left;
        while (i < leftArray.length && j < rightArray.length){
            if (leftArray[i] < rightArray[j]){
                arr[k++] = leftArray[i++];
            }
            else {
                arr[k++] = rightArray[j++];
                ans += mid +1 - (left+i);
            }
        }

        while (i < leftArray.length)
            arr[k++] = leftArray[i++];
        while (j < rightArray.length)
            arr[k++] = rightArray[j++];
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,4,7,9,1,2,4,9,};
        mergeAndCount(arr,0,8);
        System.out.println(Arrays.toString(arr));
    }


    public int expressiveWords(String S, String[] words) {
        if (S == null || words == null) {
            return 0;
        }
        int count = 0;
        for (String word : words) {
            if (stretchy(S, word)) {
                count++;
            }
        }
        return count;
    }

    public boolean stretchy(String S, String word) {
        if (word == null) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) == word.charAt(j)) {
                int len1 = getRepeatedLength(S, i);
                int len2 = getRepeatedLength(word, j);
                if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
                    return false;
                }
                i += len1;
                j += len2;
            } else {
                return false;
            }
        }
        return i == S.length() && j == word.length();
    }

    public int getRepeatedLength(String str, int i) {
        int j = i;
        while (j < str.length() && str.charAt(j) == str.charAt(i)) {
            j++;
        }
        return j - i;
    }






}
