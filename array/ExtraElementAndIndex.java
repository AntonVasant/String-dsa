package array;

public class ExtraElementAndIndex {
    public int[] extraElement(int[] array1,int[] array2){
        int[] res = new int[2];
        for(int i=0;i< array1.length;i++){
            if(array1[i] != array2[i]){
                res[0]=array2[i];
                res[1]=i;
            }
        }
        return res;
    }
}
