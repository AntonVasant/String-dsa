package inplace;

public class CircularSubArraySum {

    static int circularSubarraySum(int[] arr) {
        int n = arr.length;
        int maxCurrent = arr[0];
        int maxSoFar = arr[0];
        int minCurrent = arr[0];
        int minSoFar = arr[0];
        for (int i = 1; i < n; i++){
            maxCurrent = Math.max(arr[i],maxCurrent + arr[i]);
            maxSoFar = Math.max(maxSoFar,maxCurrent);
            minCurrent = Math.min(arr[i],minCurrent + arr[i]);
            minSoFar = Math.min(minSoFar,minCurrent);
        }

        int total = 0;
        for (int num : arr) total += num;

        int circular = total - minSoFar;
        return Math.max(circular,maxSoFar);
    }
}
