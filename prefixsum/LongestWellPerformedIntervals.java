package prefixsum;

public class LongestWellPerformedIntervals {
    public int longestWPI(int[] hours) {
        int count = 0;
        int max = 0;
        int left = 0;
        int n = hours.length;
        for (int right = 0; right < n; right++){
            if (hours[right] > 7)
                count++;
            while (count <= (right- left+1)){
                if (hours[left] > 7)
                    count--;
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
