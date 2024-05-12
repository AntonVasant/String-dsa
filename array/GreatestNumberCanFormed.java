package array;

import java.util.Arrays;
public class GreatestNumberCanFormed {
    public String number(int[] array){
        String[] numString = new String[array.length];
        for (int i=0;i<array.length;i++){
            numString[i]=String.valueOf(array[i]);
        }
       Arrays.sort(numString,(a,b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for(String str : numString){
            sb.append(str);
        }
        return sb.toString();
    }
}
