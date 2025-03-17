package greedy;

import java.util.Arrays;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++){
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i]-1] != arr[i])
                swap(arr,i,arr[i]-1);
        }

        for (int i = 0; i < n; i++){
            if (arr[i] != i+1){
                System.out.println(Arrays.toString(arr));
                return i+1;
            }

        }
        return n+1;
    }

    private static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static int missingNumber(int n, int arr[]) {

        for (int i = 0; i < n; i++){
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i]-1] != arr[i])
                swap(arr,i,arr[i]-1);
        }

        for (int i = 0; i < n; i++){
            if (arr[i] != i+1)
                return i+1;
        }
        return n;
    }
    public static void main(String[] args) {
        int n = missingNumber(4,new int[]{1,2,3,5});
        System.out.println(n);
    }
}
