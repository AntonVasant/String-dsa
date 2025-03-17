package gfg;

public class MaxProductArray {
    public static int maximumProductSubArray(int[] arr){
        int maxProduct = arr[0];
        int currentMin = arr[0];
        int currentMax = arr[0];
        for (int i = 1; i < arr.length; i++){
            int num = arr[i];
            if (num < 0){
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(num,currentMax *num);
            currentMin = Math.min(num, currentMin * num);
            maxProduct = Math.max(maxProduct,currentMax);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maximumProductSubArray(new int[]{ 3, 4, 5, -9}));
    }
}
