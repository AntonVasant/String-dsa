package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestMultipleOfThree {
    public String largestMultipleOfThree(int[] digits) {
        List<Integer> remainder1 = new ArrayList<>();
        List<Integer> remainder2 = new ArrayList<>();
        int sum= 0;
        for (int num : digits){
            sum += num;
            if (num % 3 == 1) remainder1.add(num);
            else if (num %3 == 2) remainder2.add(num);
        }
        Collections.sort(remainder2);
        Collections.sort(remainder1);
        if (sum %3 == 1){
            if (!remainder1.isEmpty()){
                digits = helper(digits,remainder1.get(0));
            } else if (remainder2.size() >= 2) {
                digits = helper(digits,remainder2.get(0));
                digits = helper(digits,remainder2.get(1));
            }
            else return "";
        } else if (sum % 3 == 2) {
            if (!remainder2.isEmpty()){
                digits = helper(digits,remainder2.get(0));
            } else if (remainder1.size() >= 2) {
                digits = helper(digits,remainder1.get(0));
                digits = helper(digits,remainder1.get(1));
            }
            else return "";
        }

        List<Integer> ans = new ArrayList<>();
        for (int n : digits){
            if (n != -1) ans.add(n);
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(ans,Collections.reverseOrder());
        for (int n : ans)
            sb.append(n);
        return sb.toString();
    }

    private int[] helper(int[] array,int num){
        for (int i = 0; i < array.length; i++){
            if (array[i] == num){
                array[i] = -1;
                break;
            }
        }
        return array;
    }
}
