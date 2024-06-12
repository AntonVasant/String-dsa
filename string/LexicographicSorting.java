package string;


import java.util.Arrays;

public class LexicographicSorting {
    public static void sorting(String[] array){
        Arrays.sort(array);
        for (String s : array)
            System.out.println(s+" ");
    }
}
