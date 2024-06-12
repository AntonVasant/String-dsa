package rescursion;

import java.util.List;

public class PartitionSubsetMinimumDifference {
    public static void partition(int[] array, int index, int sum1, int sum2, List<Integer> partition1, List<Integer> partition2) {
        if (index == array.length) {
            return;
        }


        partition(array, index + 1, sum1 + array[index], sum2, partition1, partition2);



        partition(array, index + 1, sum1, sum2 + array[index], partition1, partition2);


        // Add element to the partition with smaller sum difference
        if (Math.abs((sum1 + array[index]) - sum2) < Math.abs((sum2 + array[index]) - sum1)) {
            partition1.add(array[index]);
        } else {
            partition2.add(array[index]);
        }
    }

}
