package inplace;

public class MinimumMaximum {

    public static void rearrange(long arr[], int n){
        long max = arr[n-1]+1;
        int minIndex = 0;
        int maxIndex = n-1;
        for (int i = 0; i < n; i++)
            if (i%2 == 0)
                arr[i] += (arr[maxIndex--]%max) * max;
            else
                arr[i] += (arr[minIndex++]%max) + max;

        for (int i = 0; i < n; i++)
            arr[i] /= max;
    }

    static void rePlace(long arr[],int n){
        for (int i = 0; i < n; i++){
            arr[i] += (arr[(int) arr[i]]% n) *n;
        }
        for (int i = 0; i < n; i++)
            arr[i] /= n;
    }
}
