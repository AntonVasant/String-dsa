package array;

public class EquilibriumIndex {
    public int index(int[] array){
        int total=0;
        int leftSum=0;
        for (int num : array)
            total+=num;
        for (int i=0;i<array.length;i++){
            total-=array[i];
            if (total==leftSum)
                return array[i];
            leftSum+=array[i];

        }
        return -1;
    }
}
