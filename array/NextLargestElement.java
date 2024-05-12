package array;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestElement {
    public int[] largest(int[] array){
        int[] result = new int[array.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<array.length;i++){
            while (!stack.isEmpty() && array[i]>array[stack.peek()])
                result[stack.pop()]=array[i];
            stack.push(i);
        }
        return result;
    }
}
