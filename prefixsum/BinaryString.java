package prefixsum;

import java.util.Random;

public class BinaryString {

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] arr = new int[n];
        int left = 0;
        int operations = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0){
                operations += left;
                arr[i] = operations;
            }
            if (boxes.charAt(i) == 'I')
                left++;
        }

        left = 0;
        operations = 0;

        for (int i = n-1; i >= 0; i--) {
            if (i < n- 1){
                operations += left;
                arr[i] += operations;
            }
            if (boxes.charAt(i) == 'I')
                left++;
        }
        return arr;
    }
    public int maxTurbulenceSize(int[] A) {
        int best = 0, clen = 0;

        for(int i = 0; i < A.length; i++) {
            if(i >= 2 && ((A[i-2] > A[i-1] && A[i] > A[i-1]) ||
                    (A[i-1] > A[i-2] && A[i-1] > A[i])) ) {

                clen++;
            } else if(i >= 1 && A[i-1] != A[i]) {

                clen = 2;
            } else {

                clen = 1;
            }
            best = Math.max(best, clen);
        }
        return best;
    }
    static int find(int N){
        String num = Integer.toString(N);
        int n = num.length();
        int index = -1;
        char[] arr = num.toCharArray();
        for (int i = 0; i < n-1; i++) {
            if (arr[i] > arr[i+1]){
                index = i;
                break;
            }
        }
        /*
                For Input:
        331
        Your Code's output is:
        329
        It's Correct output is:
        299
         */

        if (index == -1) return N;
        while (index > 0 && arr[index] <= arr[index - 1]){
            arr[index - 1] = arr[index];
            index--;
        }
        arr[index]--;
        for (int i = index+1; i < n; i++)
            arr[i] = '9';
        return Integer.parseInt(new String(arr));
    }
    public String LargestEven(String S){

        char[] arr = S.toCharArray();
        int i = 0;
        int n = arr.length;
        int j = n - 1;
        while (i < j){
            swap(arr,i++,j--);
        }

        int index = -1;
        for (int k = n- 1; k >= 0 ; k++){
            if ((arr[k] - '0') % 2 == 0){
                index = k;
                break;
            }
        }

        if (index == -1)
            return new String(arr);

       StringBuilder builder =  new StringBuilder();
       for (int k = 0; k < n; k++){
           if (k == index) continue;
           builder.append(arr[k]);
       }
        builder.append(arr[index]);
       return builder.toString();
    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static String findLargest(int n, int s) {
        if (s == 0 && n > 1) return "-1";

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++){
            if (s >= 9){
                builder.append(9);
                s -= 9;
            }
            else {
                builder.append(s);
                s-= s;
            }
        }

        if (s > 0) return "-1";
        return builder.toString();
    }

    public static String smallestNumber(int s, int d) {
        if (d * 9 < s) return "-1";

        int n = (int)Math.pow(10, d - 1);
        int sum = s - 1;
        char[] temp = Integer.toString(n).toCharArray();

        int i = d - 1;
        while (i >= 0 && sum > 0) {
            if (sum > 9) {
                temp[i] = '9';
                sum = sum - 9;
            } else {
                int val = temp[i] - '0';
                val = val + sum;
                temp[i] = (char)((int)'0' + val);
                sum = 0;
            }
            i--;
        }
        return new String(temp);
    }



    public static void main(String[] args) {
        smallestNumber(9,2);
        Random random = new Random();

    }
}
