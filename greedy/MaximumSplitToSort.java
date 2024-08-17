package greedy;

public class MaximumSplitToSort {
    public int maxChunksToSorted(int[] arr) {
        int[] array = new int[10];
        for (int i = 0; i < arr.length; i++){
            array[arr[i]] = i;
        }
        int count = 0;
        int j = -1;
        for (int i = 0; i < arr.length; i++){
            j = Math.max(j,array[i]);
            if (j == i) count++;
        }
        return count;
    }
}
/*
The problem can be thought of as tracking the maximum index we need to reach for each element to ensure the entire chunk
can be sorted correctly. If at any point the current index matches this maximum index, it indicates that all elements up to
this point can form a valid sorted chunk.

Approach
Initialize Variables:

j to keep track of the farthest index we need to reach to sort the current chunk.
c to count the number of valid chunks.
Fill the f array:

Iterate through the array and update f to record the last position of each number.
Form Chunks:

Iterate through the array again and update j to the maximum index required to sort the current chunk.
If the current index i equals j, it means we can form a chunk up to this index, and we increment the chunk counter c.
Return the Chunk Count:
 */
