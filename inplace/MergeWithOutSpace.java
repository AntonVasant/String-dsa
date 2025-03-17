package inplace;

public class MergeWithOutSpace {

    public static void merge(int n, int m, long arr1[], long arr2[]) {

        int gap = gap(n+m);
        while (gap > 0){
            int i,j;
            for (i = 0; i + gap < n; i++){
                if (arr1[i] > arr1[i+gap])
                    swap(arr1,i,i+gap);
            }

            for (j = (gap > n) ? gap-n : 0; j < m && i < n; j++, i++){
                if (arr1[i] > arr2[j]){
                    long temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            for (j = 0; j + gap < m; j++){
                if (arr2[j] > arr2[j+gap])
                    swap(arr2,j,j+gap);
            }

            gap = gap(gap);
        }
    }


    private static int gap(int n){
        if (n <= 1) return 0;

        return n/2  + n%2;
    }

    private static void swap(long[] arr,int i,int j){
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
