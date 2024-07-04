package array;

import java.util.Stack;

public class MaximalRect {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] height = new int[n];
        int row = matrix.length;
        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < n; j++){
                height[j] = matrix[i][j] == '0' ? 0 : height[j]+1;
            }
            ans = Math.max(ans,area(height));
        }
        return ans;
    }

    public int area(int[] heights) {
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
