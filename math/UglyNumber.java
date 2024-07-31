package math;

public class UglyNumber {
    public boolean isUgly(int n) {
        return helper(n);
    }

    private boolean helper(int n){
        if (n <= 1) return true;
        int[] p = {2,3,5};
        for(int num : p){
            while (n %num == 0)
                n/= num;
        }
        return n == 1;
    }
}
