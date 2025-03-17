package inplace;

public class FirstMissingPositiveNumber {
    public static int missingPositive(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            while (arr[i] > 0 &&  arr[i] <= n && arr[i] != arr[arr[i] -1]){
                int temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1] = temp;
            }
        }

        for (int i = 0; i < n; i++){
            if (arr[i] != i+1) return i+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        System.out.println(missingPositive(new int[]{1,2,3,4,5,6,7}));
    }
}
