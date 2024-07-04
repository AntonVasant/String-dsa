package greedy;

import java.util.Arrays;

public class Boats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int right = people.length-1;
        int left = 0;
        int ans = 0;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }right--;
            ans++;
        }
        return ans;
    }
}
