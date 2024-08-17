package matrix;
import java.util.HashMap;
import java.util.Map;
public class SubMatrixSumTarget {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            // Step 1: Calculate prefix sums for each row
            for (int[] row : matrix) {
                for (int col = 1; col < cols; col++) {
                    row[col] += row[col - 1];
                }
            }

            int count = 0;

            // Step 2: For each pair of columns, use a hashmap to find subarrays with sum equals target
            for (int colStart = 0; colStart < cols; colStart++) {
                for (int colEnd = colStart; colEnd < cols; colEnd++) {
                    Map<Integer, Integer> sumCount = new HashMap<>();
                    sumCount.put(0, 1); // Base case: a sum of 0 initially
                    int currentSum = 0;

                    for (int row = 0; row < rows; row++) {
                        // Current sum from colStart to colEnd in row `row`
                        currentSum += matrix[row][colEnd] - (colStart > 0 ? matrix[row][colStart - 1] : 0);

                        // If (currentSum - target) exists in the map, it means there is a submatrix that sums to target
                        count += sumCount.getOrDefault(currentSum - target, 0);

                        // Update the map with the current sum
                        sumCount.put(currentSum, sumCount.getOrDefault(currentSum, 0) + 1);
                    }
                }
            }

            return count;
        }

}
