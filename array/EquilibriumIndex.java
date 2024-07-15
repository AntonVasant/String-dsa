package array;

import java.util.Arrays;

public class EquilibriumIndex {
    public int index(int[] array){
        int leftSum=0;
        int total = Arrays.stream(array).sum();
        for (int i=0;i<array.length;i++){
            total-=array[i];
            if (total==leftSum)
                return array[i];
            leftSum+=array[i];

        }
        return -1;
    }
}
