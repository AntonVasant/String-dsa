package array;

import java.util.Random;

public class ShuffleArray {
    public int[] shuffle(int[] array){
        Random rand = new Random();
        for (int i=array.length-1;i>=0;i--){
            int index = rand.nextInt(i+1);
            int temp = array[i];
            array[i]=array[index];
            array[index]=temp;
        }
        return array;
    }
}
