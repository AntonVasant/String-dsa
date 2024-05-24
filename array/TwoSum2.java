package array;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int left =0;
        int right= numbers.length-1;
        int total=0;
        while(left < right){
            total = numbers[left] + numbers[right];
            if(total > target)
                right--;
            else if(total == target)
                return new int[]{left+1,right+1};
            else left++;
        }
        return new int[]{-1,-1};
    }
}
