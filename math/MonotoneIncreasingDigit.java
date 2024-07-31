package math;

public class MonotoneIncreasingDigit {
    public int monotoneIncreasingDigits(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int len = arr.length;
        int pos = -1;
        for (int i = len-1;i >0; i--){
            if (arr[i] < arr[i-1]){
                pos = i;
                arr[i-1]--;
            }
        }
       if (pos != -1){
           for (int i = pos; i < len; i++){
               arr[i] = '9';
           }
       }
        return Integer.parseInt(new String(arr));
    }
}
