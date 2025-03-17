package string;

import java.util.Arrays;

public class PalindromicSubString {
    public static void main(String[] args) {
        int[] arr  = {5,3,7,2,3,6,3,7,9,1};


        System.out.println(twoSum(arr, 17));


        // 1,2,3,4,5,6,7,8,9 -> 8 7 6 5 4 3 2 1


    }


    public static boolean twoSum(int[] array, int target) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length-1;


        while (left < right) {

            int sum = array[left] + array[right];

            if (sum == target){
                System.out.println(array[left]+ " "+ array[right]);
                return true;
            }

            if (sum > target) {
                right--;
            }
            else {
                left++;
            }
        }

        return false;
    }
    public static void stringReverse(String s) {
        char[] arr = s.toCharArray();
        System.out.println(Arrays.toString(arr));

        int left = 0;
        int right = arr.length-1;

        while (left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right]  = temp;
            left++;
            right--;

        }

        System.out.println(Arrays.toString(arr));

        String ans = new String(arr);
        System.out.println(ans);



    }
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(array));
    }



}
