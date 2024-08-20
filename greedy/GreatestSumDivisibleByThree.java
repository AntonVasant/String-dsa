package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreatestSumDivisibleByThree {
    public int maxSumDivThree(int[] nums) {

        List<Integer> remainder1= new ArrayList<>();
        List<Integer> remainder2 = new ArrayList<>();
        int totalSum = 0;
        for (int num : nums){
            totalSum+= num;
            if (num % 3 == 1) remainder1.add(num);
            else if (num%3 == 2) {
                remainder2.add(num);
            }
        }
        if (totalSum%3 == 0)return totalSum;
        Collections.sort(remainder1);
        Collections.sort(remainder2);
        if (totalSum %3 == 1){
            int option1 = (!remainder1.isEmpty()) ? remainder1.get(0) : Integer.MAX_VALUE;
            int option2 = (remainder2.size() > 1) ? remainder2.get(0) + remainder2.get(1) : Integer.MAX_VALUE;
            return totalSum - Math.min(option1,option2);
        }
        else {
            int option1 = (remainder1.size() > 1) ? remainder1.get(0) + remainder1.get(1) : Integer.MAX_VALUE;
            int option2 = (!remainder2.isEmpty()) ? remainder2.get(0) : Integer.MAX_VALUE;
            return totalSum - Math.min(option1,option2);
        }
    }
}
