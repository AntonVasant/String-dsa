package array;

public class RotateArray {
    public int[] rotate(int[] array,int k){
        int len= array.length;
        rot(array,0,len-1);
        rot(array,0,k-1);
        rot(array,k,len-1);
        return array;
    }
    private void rot(int[] array,int start,int end){
        int temp;
        while (start<=end){
            temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
    }
}
