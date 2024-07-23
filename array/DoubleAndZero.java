package array;

import java.util.Arrays;

public class DoubleAndZero {
    public static int[] doubleZero(int[] array){
        for (int i=0;i< array.length-1;i++){
            if (array[i] == 0) continue;
            if(array[i]==array[i+1]){
                array[i]+=array[i+1];
                array[i+1]=0;
                i++;
            }
        }
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] != 0){
                array[index++] = array[i];
            }
        }
        for (int i = index; i < array.length; i++){
            array[index++] = 0;
        }
        System.out.print(Arrays.toString(array));
        return array;
    }
}
