package rescursion;

import java.util.Arrays;
import java.util.List;

public class AlternativeSubSequence {
    public static int subSequence(int[] array){
        int inc = helper(array,0,-4,true);
        int dec = helper(array,0,Integer.MAX_VALUE,false);
        return Math.max(inc,dec);
    }

    private static int helper(int[] array,int index,int prev,boolean isIncreasing){
        if (index == array.length) return 0;

        int take = 0;
        if (isIncreasing){
            if (array[index] > prev)
                take = 1 + helper(array, index+1, array[index], false);

        }else {
            if (array[index] < prev)
                take = 1 + helper(array, index+1, array[index], true);

        }
        int nonTake = helper(array, index+1, prev, isIncreasing);
        return Math.max(take,nonTake);
    }
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length, ans = 0;
        int[] cnt = new int[121]; // Frequency array for ages 1 to 120

        for (int i = 0; i < n; i++) {
            int ageX = ages[i];
            if (ageX <= 14) continue;
            int lo = 0, hi = i - 1, res = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (ages[mid] > (ageX / 2 + 7)) {
                    hi = mid - 1;
                    res = mid;
                } else
                    lo = mid + 1;

            }
            if (res != -1) {
                ans += (i - res);
                ans += cnt[ageX];
            }
            cnt[ageX]++;
        }

        return ans;
    }
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int n = aliceSizes.length;
        Arrays.sort(bobSizes);
        int bobTotal = Arrays.stream(bobSizes).sum();
        int aliceTotal = Arrays.stream(aliceSizes).sum();
        for (int i = 0; i < n; i++){
            int target = (bobTotal + 2 * aliceSizes[i] - aliceTotal)/2;
            if (binarySearch(bobSizes, target))
                return new int[]{aliceSizes[i], target};
        }
        return new int[]{0,0};
    }

    private boolean binarySearch(int[] arr ,int n){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] == n)
                return true;
            else if (arr[mid] < n)
                low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }



}
