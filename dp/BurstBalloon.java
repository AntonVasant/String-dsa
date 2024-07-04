package dp;

public class BurstBalloon {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] extendedNums = new int[n + 2];
            extendedNums[0] = extendedNums[n + 1] = 1;
            for (int i = 1; i <= n; i++) {
                extendedNums[i] = nums[i - 1];
            }

            int[][] memo = new int[n + 2][n + 2];
            return burst(memo, extendedNums, 0, n + 1);
        }

        private int burst(int[][] memo, int[] nums, int left, int right) {
            if (left + 1 == right) {
                return 0;
            }
            if (memo[left][right] > 0) {
                return memo[left][right];
            }
            int maxCoins = 0;
            for (int i = left + 1; i < right; i++) {
                int coins = nums[left] * nums[i] * nums[right];
                coins += burst(memo, nums, left, i) + burst(memo, nums, i, right);
                maxCoins = Math.max(maxCoins, coins);
            }
            memo[left][right] = maxCoins;
            return maxCoins;
        }
    }
    
