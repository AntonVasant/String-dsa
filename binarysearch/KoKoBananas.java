package binarysearch;

public class KoKoBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int num : piles){
            if(num > max)
                max = num;
        }
        int low = 1;
        int high = max;
        int mid;
        int ans = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(helper(piles,mid) <= h){
                high = mid - 1;
                ans = mid;
            }else low = mid + 1;
        }
        return ans;
    }

    private static int helper(int[] array,int mid){
        int total = 0;
        for(int i = 0; i < array.length; i++){
            total += (int)Math.ceil(array[i] /mid);
        }
        return total;
    }
}
