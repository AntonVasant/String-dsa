package array;
import java.util.TreeSet;
public class ContainsDuplicate3 {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (nums == null || nums.length < 2 || k < 1 || t < 0) {
                return false;
            }

            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                long current = nums[i];

                // Check for any number in the set that is within range [current - t, current + t]
                Long floor = set.floor(current + t);
                if (floor != null && floor >= current - t) {
                    return true;
                }

                set.add(current);

                // Maintain the window of size k
                if (set.size() > k) {
                    set.remove((long) nums[i - k]);
                }
            }

            return false;
        }

        public static void main(String[] args) {
            ContainsDuplicate3 obj = new ContainsDuplicate3();
            int[] nums = {1, 2, 3, 1};
            int k = 3;
            int t = 0;
            System.out.println(obj.containsNearbyAlmostDuplicate(nums, k, t)); // Output: true

            nums = new int[]{1, 0, 1, 1};
            k = 1;
            t = 2;
            System.out.println(obj.containsNearbyAlmostDuplicate(nums, k, t)); // Output: true

            nums = new int[]{1, 5, 9, 1, 5, 9};
            k = 2;
            t = 3;
            System.out.println(obj.containsNearbyAlmostDuplicate(nums, k, t)); // Output: false
        }
    }

