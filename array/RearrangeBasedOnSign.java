package array;

public class RearrangeBasedOnSign {
    public int[] rearrangeArray(int[] nums) {
        int[] rearranged = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                rearranged[posIndex] = nums[i];
                posIndex += 2;
            } else {
                rearranged[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return rearranged;
    }

}
