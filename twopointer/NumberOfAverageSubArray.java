package twopointer;

public class NumberOfAverageSubArray {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;
        int avg = 0;
        int len = arr.length;
        for(int i = 0;i<k;i++){
            sum += arr[i];
        }
        avg = sum/k;
        if(avg >= threshold) count++;
        for(int i = k;i<len;i++){
            sum = (sum - arr[i-k] + arr[i]);
            avg = sum/k;
            if(avg >= threshold)
                count++;
        }
        return count;
    }
}
