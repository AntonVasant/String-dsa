package array;

public class MoveZero {
    public int[] zero(int[] array){
        int[] result= new int[array.length];
        int index=0;
        for(int num : array){
            if(num !=0)
                result[index++]=num;
        }
        for(int i=index;i< array.length;i++){
            array[i]=0;
        }
        return result;
    }
}
