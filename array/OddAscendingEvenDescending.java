package array;

import java.util.Arrays;

public class OddAscendingEvenDescending {
    public int[] ascendingDescending(int[] array){
        int n = array.length;
        int[] odd =  new int[n];
        int[] even= new int[n];
        int oddIndex=0;
        int evenIndex=0;
        for(int num : array){
            if(num%2==0)
                even[evenIndex++]=num;
            else odd[oddIndex++]=num;
        }
        Arrays.sort(odd,0,oddIndex);
        Arrays.sort(even,0,evenIndex);
        int[] result = new int[n];
        int index=0;
        for(int i=0;i<oddIndex;i++){
            result[index++]=odd[i];
        }
        for(int i=evenIndex-1;i>=0;i--){
            result[index++]=even[i];
        }
        return result;
    }
}
