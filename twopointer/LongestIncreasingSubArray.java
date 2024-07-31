package twopointer;

public class LongestIncreasingSubArray {
    public long lenOfLongIncSubArr(long arr[], long n)
    {
        long len = 0;
        long ma = 0;
        for (int right = 1; right < arr.length; right++){
            if (arr[right] > arr[right-1]) {
                len++;
                ma = Math.max(ma, len);
            }else len = 1;
        }
        return ma;
    }
}
