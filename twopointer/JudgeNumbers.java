package twopointer;

public class JudgeNumbers {
    public boolean judgeSquareSum(int c) {
        int low = 1;
        int high = c;
        while(low < high){
            int n = square(low,high);
            if (n == c) return true;
            else if (n > c) {
                high--;
            }else low++;
        }
        return false;
    }

    private int square(int i,int j){
        return i*i+j*j;
    }
}
