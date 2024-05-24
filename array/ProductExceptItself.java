package array;

public class ProductExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int leftProduct =1;
        for(int i =0;i<nums.length;i++){
            left[i] = leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = 1;
        for(int i = nums.length-1;i>=0;i--){
            right[i] = rightProduct;
            rightProduct *= nums[i];
        }
        for(int i =0;i<nums.length;i++){
            left[i] *= right[i];
        }
        return left;
    }
}
