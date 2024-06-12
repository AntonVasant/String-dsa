package string;

import java.util.Arrays;

public class LargestNumberFormed {
    public static void numberFormed(int[] num){
        String[] array = new String[num.length];
        for (int i = 0; i < num.length; i++){
            array[i] = String.valueOf(num[i]);
        }
        Arrays.sort(array,(a,b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for (String s : array){
            sb.append(s);
        }
        System.out.println(sb);
    }
}
