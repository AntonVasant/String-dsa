

public class Practice {
    public int returnToBoundaryCount(int[] nums) {
        int[] prefix = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++)
            prefix[i+1] = prefix[i] + nums[i];
        int ans = 0;
        for (int i = 1; i < prefix.length; i++){
            if (prefix[i] == 0) ans++;
        }
        return ans;
    }
}
