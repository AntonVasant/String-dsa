package binarysearch;

import java.util.Arrays;

public class Heater {
    public int findRadius(int[] houses, int[] heaters) {
        int distance = Integer.MIN_VALUE;
        Arrays.sort(heaters);
        for (int house : houses){
            int radius = helper(house,heaters);
            distance = Math.max(distance,radius);
        }
        return distance;
    }

    private int helper(int house ,int[] heaters){
        int low = 0;
        int high = heaters.length-1;
        int mid;
        while (low <= high){
            mid =  low + (high - low) / 2;
            if (heaters[mid] < house){
                low = mid+1;
            }
            else high = mid-1;
        }

        int right = (high >= 0) ? Math.abs(heaters[high] - house) : Integer.MAX_VALUE;
        int left = (low < heaters.length) ? Math.abs(heaters[low] - house) : Integer.MAX_VALUE;
        return Math.min(right,left);
    }
}
