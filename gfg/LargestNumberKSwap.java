package gfg;

import java.util.HashMap;
import java.util.Map;

public class LargestNumberKSwap {
    public static String findMaximumNum(String str, int k)
    {
        return helper(str.toCharArray(),k,new String(str.toCharArray()));
    }


    private static String helper(char[] array,int k, String str){
        if (k == 0) return str;


        for (int i = 0; i < str.length()-1; i++){
            for (int j = i + 1; j < str.length(); j++){
                if (array[j] > array[i]){
                    swap(array,i,j);
                    String s = new String(array);
                    if (s.compareTo(str) > 0)
                        str = s;
                    str = helper(array,k-1,str);
                    swap(array,i,j);
                }

            }
        }
        return str;
    }

    private static void swap(char[] arr,int i,int j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static int minIndexChar(String str, String patt)
    {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < patt.length(); i++){
            map.put(patt.charAt(i), map.getOrDefault(patt.charAt(i),0)+1);
        }
        for (char c : str.toCharArray())
            if (map.containsKey(c)) return map.get(c);
        return -1;
    }

    public char nthCharacter(String s, int r, int n)
    {
        String st = helper(s,r);
        return st.charAt(n);
    }

    private String helper(String s,int k){
        StringBuilder sb = new StringBuilder();
        if (k == 0) return s;
        for (char c : s.toCharArray()){
            if (c == '0')
                sb.append("01");
            else sb.append("10");
        }
        return helper(sb.toString(),k-1);
    }

    public static void main(String[] args) {

    }
}
