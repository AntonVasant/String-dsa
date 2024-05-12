package array;

public class PlusOne {
    public int[] plus(int[] array){
        for(int i =0;i< array.length;i++){
            if(array[i]<9){
                array[i]++;
                return array;
            }else array[i]=0;
        }
        int[] arrays = new int[array.length+1];
        arrays[0]=1;
        return arrays;
    }
}
