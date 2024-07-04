package binarysearch;

public class Bouquet {

    public static int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int n : bloomDay){
            if(n < low) low = n;
            if(n > high) high = n;
        }
        System.out.println(high);
        System.out.println(low);
        int mid;
        int ans = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(isPossible(bloomDay,m,k,mid)){
                ans = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return ans;
    }
    public static boolean isPossible(int[] array, int m, int k, int mid) {
        int consecutive = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= mid) {
                consecutive++;
                if (consecutive == k) {
                    m--;
                    consecutive = 0;
                    if (m == 0) return true;
                }
            } else {
                consecutive = 0;
            }
        }
        return false;
    }
}
