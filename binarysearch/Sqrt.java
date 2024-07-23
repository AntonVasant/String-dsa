package binarysearch;

public class Sqrt {
    public static void mySqrt(int x) {
        int high = x;
        int low = 1;
        int mid;
        int ans = 0;
        while(low <= high){
            mid = (high + low)/2;
            if(mid <= x/mid){
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        System.out.println(ans);
    }
}
