package string;

public class StrStr {
    public int strStr(String s,String x){
       int n = s.length();
       int m = x.length();
       if (m == 0) return 0;
       for (int i = 0; i < n-m; i++){
           int j;
           for (j = 0; j < m; j++){
               if (s.charAt(i+j) != x.charAt(j)) break;
           }
           if (j == m) return i;
       }
       return -1;
    }
}
