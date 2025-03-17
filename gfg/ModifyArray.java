package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ModifyArray {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++){
            if (arr[i] == arr[i-1]){
                arr[i-1] = arr[i]+ arr[i];
                arr[i] = 0;
                i++;
            }
        }
        int index =0 ;
        for (int i = 0; i < n; i++){
            if (arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr)
            list.add(num);
        return list;
    }


    //smallest from the left of the array
    static List<Integer> leftSmaller(int n, int a[])
    {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        list.add(-1);
        stack.push(a[0]);
        for (int i = 1; i < n; i++){
            while (!stack.isEmpty() && a[i] < stack.peek())
                stack.pop();
            if (!stack.isEmpty())
                list.add(stack.peek());
            else list.add(-1);
            stack.push(a[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(leftSmaller(3, new int[]{1, 6,2}));
    }
}
