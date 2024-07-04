package array;

import java.util.Stack;

public class HistoGramRectangle {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int index = 0;
        while (index < heights.length){
            if(stack.isEmpty() || heights[index] >= heights[stack.peek()]){
                stack.push(index++);
            }else{
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? index : index - stack.peek()-1;
                max = Math.max(max,height * width);
            }
        }

        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? index : index - stack.peek()-1;
            max = Math.max(max,height * width);
        }
        return max;
    }
}
