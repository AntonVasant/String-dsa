package gfg;

import java.util.Arrays;

public class MinimumPlatforms {

    public static int minimum(int[] arrival, int[] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int maxNeed = 1;
        int current = 0;
        int i = 0, j = 0;
        int n = arrival.length;
        while (i < n && j < n){
            if (arrival[i] <= departure[j]){
                current++;
                i++;
            }
            else {
                current--;
                j++;
            }
            maxNeed = Math.max(maxNeed,current);
        }
        return maxNeed;
    }

    public static void main(String[] args) {
        System.out.println(minimum(new int[]{88, 90, 755, 678, 875, 3253}, new int[]{89, 90, 756,679, 876, 322322}));
    }
}
