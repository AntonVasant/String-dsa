package binarysearch;

public class PeakInMountain {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        int mid;
        int ans = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(mid == 0) return high;
            if(arr[mid] > arr[mid-1]){
                ans = mid;
                low = mid + 1;
            }else{
                if(arr[mid] > arr[ans]) ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}
