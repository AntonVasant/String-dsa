package array;

public class DoubleAndZero {
    public int[] doubleZero(int[] array){
        for (int i=0;i< array.length;i++){
            if(array[i]==array[i+1]){
                array[i]+=array[i+1];
                array[i+1]=0;
                i++;
            }
        }
        return array;
    }
}
