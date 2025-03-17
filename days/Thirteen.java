package days;

import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Stack;

public class Thirteen {

    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int n = nums.length;
        boolean[] used = new boolean[n];
        long score = 0;
        for (int i = 0; i < n; i++){
            pq.offer(new int[]{nums[i], i});
        }

        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int value = cur[0];
            int index = cur[1];
            if (used[index]) continue;
            score += value;
            used[index] = true;
            if (index > 0) used[index-1] = true;
            if (index < n-1) used[index+1] = true;
        }
        return score;
    }
    private static final String[] LESS_THAN_20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] THOUSANDS = {
            "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) return "zero";
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (num > 0){
            if (num % 1000 != 0){
                builder.insert(0,helper(num%1000)+" "+THOUSANDS[index]+" ");
            }
            index++;
            num /= 1000;
        }
        return builder.toString().trim();
    }
    private String helper(int num){
        if (num == 0)
            return "";
        if (num < 20) return LESS_THAN_20[num];
        else if (num < 100) return TENS[num/10]+" " + helper(num%10);
        else return LESS_THAN_20[num/100]+" Hundred "+helper(num%100);
    }
    public int findMaximum(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        if (arr[0] > arr[1]) return arr[0];
        if (arr[n-1] > arr[n-2]) return arr[n-1];
        int left = 1;
        int right = n-2;
        while (left <= right){
            int mid = (left + right)/2;
            if (arr[mid] > arr[mid-1]){
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return arr[right];
    }

    public boolean searchMatrix(int[][] mat, int x) {
        int row = mat.length;
        int col = mat[0].length;
        int low = 0;
        int high = row * col -1;
        while (low <= high){
            int mid = (low + high)/2;
            int r = mid /col;
            int c = mid % col;
            if (mat[r][c] == x) return true;
            else if (mat[r][c] > x) high = mid - 1;
            else low = mid +1;
        }
        return false;
    }
    public static int findNthDigit(int n) {
        int digitLength = 1;
        long count = 9;
        long start = 1;

        while (n > digitLength * count) {
            n -= (int) (digitLength * count);
            digitLength++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Identify the actual number
        start += (n - 1) / digitLength;

        // Step 3: Find the digit in the number
        String number = Long.toString(start);
        return Character.getNumericValue(number.charAt((n - 1) % digitLength));
    }

    public static void balancedParenthesis(String parenthesis){
        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int len = parenthesis.length();
        boolean[] valid = new boolean[len];
        for (int i = 0; i < len; i++){
            char c = parenthesis.charAt(i);

            if (c == '('){
                stack.push(i);
                valid[i] = true;
            }

            else if (c == ')')
                valid[stack.pop()] = false;
        }

        while (!stack.isEmpty())
            valid[stack.pop()] = true;
        for (int i = 0; i < len; i++){
            if (!valid[i])builder.append(parenthesis.charAt(i));
        }

        System.out.println(builder);
    }
    public static void main(String[] args) {
        balancedParenthesis("(((ab)");
    }
}
