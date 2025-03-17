package array;

import java.util.Arrays;

public class ZigZac {
    public static void zigZag(int n, int[] arr) {
        for (int i = 0; i < n-1; i++){
            if (i %2 == 0){
                if (arr[i] >= arr[i+1])
                    swap(arr,i,i+1);
            }
            else{
                if (arr[i] <= arr[i+1])
                    swap(arr,i,i+1);
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    private static void swap(int[] arr,int j,int i){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        zigZag(6,new int[]{2,5,4,1,6,8});
    }
}
