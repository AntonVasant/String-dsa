package array;

import java.util.Arrays;

public class SortAccordingToFactors {
    public void sort(Integer[] array){
        Arrays.sort(array,(a,b)->factors(b)-factors(a));
        for (int num : array){
            System.out.println(num);
        }
    }
    private int factors(int num){
        int count=0;
        for(int i=1;i<=num/2;i++){
            if(num%i==0)
              count++;
        }
        return count;
    }
}
