package binarysearch;

public class SmallerCharGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length-1;
        int mid;
        char ans = '\0';
        while(low <= high){
            mid = (low + high)/2;
            if(letters[mid] - target > 0){
                ans = letters[mid];
                high =mid-1;
            }else low = mid+1;
        }
        return ans == '\0' ? letters[0] : ans;
    }

}
