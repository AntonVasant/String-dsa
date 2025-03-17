package rescursion;

import org.w3c.dom.ls.LSInput;

import java.util.*;

public class PartitionToKEqualSubSet {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        int target = sum/k;
        if (sum % target != 0) return false;
        Arrays.sort(nums);
        if(nums[nums.length-1] > target) return false;
        boolean[] used= new boolean[nums.length];
        Map<String,Boolean> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0;  i < k; i++)
            list.add(new ArrayList<>());
        boolean ans = helper(nums,0,used,k,map,0,target, list);
        for (List<Integer> list1 : list)
            System.out.println(list1);
        return ans;
    }

    private static boolean helper(int[] array, int start, boolean[] used, int k,
                                  Map<String, Boolean> memo, int current, int target,
                                  List<List<Integer>> result) {
        if (k == 0) return true;
        if (current == target) {
            return helper(array, 0, used, k - 1, memo, 0, target, result);
        }
        String key = Arrays.toString(used) + start + "," + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        for (int i = start; i < array.length; i++) {
            if (!used[i] && current + array[i] <= target) {
                used[i] = true;
                result.get(k - 1).add(array[i]);
                if (helper(array, i + 1, used, k, memo, current + array[i], target, result)) {
                    memo.put(key, true);
                    return true;
                }
                used[i] = false;
                result.get(k - 1).remove(result.get(k - 1).size() - 1);
            }
        }
        memo.put(key, false);
        return false;
    }



    public static void calculate(List<String> list, String s, int index, long prev, long number, String expression, int target){
        if (index == s.length()){
            if (number == target)
                list.add(expression);
            return;
        }


        for (int i = index; i < s.length(); i++){
            if (i > index && s.charAt(index) == '0') break;;
            String currentSubString = s.substring(index, i + 1);
            long currentNumber = Long.parseLong(currentSubString);
            if (i == 0){
                calculate(list, s, i + 1, currentNumber, currentNumber, currentSubString, target);
            }
            else {
                calculate(list, s, i + 1, currentNumber, currentNumber + number,
                        expression +"+"+currentNumber, target);
                calculate(list, s, i + 1, -currentNumber, number - currentNumber,
                        expression+"-"+currentNumber, target);
                calculate(list, s, i+1, prev * currentNumber, number - prev + prev * currentNumber,
                        expression+"*"+currentNumber, target);
            }
        }
    }



    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        calculate(list,"232",0,0,0,"",8);
    }
}
