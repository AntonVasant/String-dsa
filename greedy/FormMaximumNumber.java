package greedy;

import java.util.Stack;

public class FormMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = Math.max(0,k-nums2.length); i <= Math.min(k,nums1.length); i++){
            int[] left = maxNumber(nums1,i);
            int[] right = maxNumber(nums2,k-i);
            int[] merge = merge(left,right);
            if (isGreater(merge,res,0,0))
                res = merge;
        }
        return res;
    }

    private int[] merge(int[] arr1,int[] arr2){
        int k = arr2.length + arr1.length;
        int[] result = new int[k];
        int i = 0;
        int j = 0;
        int l = 0;
        while (i < arr1.length || j < arr2.length){
            if (isGreater(arr1,arr2,i,j)){
                result[l++] = arr1[i++];
            }else result[l++] = arr2[j++];
        }
        return result;
    }
    private boolean isGreater(int[] arr1,int[] arr2,int i,int j){
        while (i < arr1.length && j < arr2.length && arr1[i] == arr2[j]){
            i++;
            j++;
        }
        return j == arr2.length || (i < arr1.length && arr1[i] > arr2[j]);
    }

    private int[] maxNumber(int[] arr,int k){
        int[] result = new int[k];
        Stack<Integer> stack = new Stack<>();
        int drops = arr.length - k;
        for (int num : arr){
            while (drops > 0 && !stack.isEmpty() && stack.peek() < num){
                drops--;
                stack.pop();
            }
            stack.push(num);
        }
        while (drops > 0){
            stack.pop();
            drops--;
        }
        for (int i = k-1; i >= 0; i--)
            result[i] = stack.get(i);
        return result;
    }
}
