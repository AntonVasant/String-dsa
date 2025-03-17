package dsscratch;

import java.util.Random;

public class Solution {

    int[] original;
    int[] array;
    Random random;

    public Solution(int[] nums) {
        original = nums.clone();
        array = nums;
        random = new Random();
    }

    public int[] reset() {
        array = original.clone();
        return array;
    }

    public int[] shuffle() {
        for (int i = array.length-1; i> 0; i--){
            int rand = random.nextInt(i);
            swap(array,i,rand);
        }
        return array;
    }

    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
