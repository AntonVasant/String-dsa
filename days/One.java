package days;

import linkedList.Node;

import java.util.*;

public class One {
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    static int minJumps(int[] nums) {
        if (nums.length <= 1) return 0;
        if (nums[0] == 0) return -1;
        int maxReach = nums[0];
        int step = nums[0];
        int jump = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) return jump;
            maxReach = Math.max(maxReach, i + nums[i]);
            step--;
            if (step == 0) {
                jump++;
                if (i >= maxReach) return -1;
                step = maxReach - i;
            }
        }

        return -1;
    }
    static void quickSort(int[] arr, int low, int high) {
        if (low < high){
            int index = partition(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1, high);
        }
    }
    static int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int pivot = arr[high];
        for (int j = low; j  < high; j++){
            if (arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = pivot;
        arr[high] = temp;
        return i + 1;
    }
    public static Node findIntersection(Node head1, Node head2) {
        Node i = head1;
        Node j = head2;
        Node current = new Node(-1);
        Node  dummy = current;
        while (i != null && j != null){
            if (i.data < j.data)
                i = i.next;
            else if (j.data < i.data)
                j = j.next;
            else {
                current.next = new Node(i.data);
                i = i.next;
                j = j.next;
                current = current.next;
            }
        }
        return dummy.next;
    }


    static int minThrow(int N, int arr[]){
        int[] board = new int[31];
        Arrays.fill(board,-1);
        for (int i = 0; i < 2 * N; i+=2){
            int start = arr[i];
            int end = arr[i+1];
            board[start] = end;
        }
        boolean[] visit = new boolean[31];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0});
        visit[0] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int position = current[0];
            int steps = current[1];
            if (position == 30)
                return steps;
            for (int i = 1; i <= 6;  i++){
                if (position + i <= 30 && !visit[position+i]){
                    int finalPosition = board[position+i] == -1 ? position+i : board[position+i];
                    visit[finalPosition] = true;
                    queue.offer(new int[]{finalPosition, steps+1});
                }
            }
        }
        return -1;
    }
    public String reverseWords(String s) {
        int n = s.length();
        int left;
        int right = 0;
        StringBuilder ans = new StringBuilder();
        while (right < n) {
            while (right < n && s.charAt(right) == ' ')
                right++;
            left = right;

            while (right < n && s.charAt(right) != ' ')
                right++;
            if (left < right) {
                String temp = reverse(s.substring(left, right).toCharArray());
                ans.append(temp).append(" ");
            }
        }
        if (!ans.isEmpty())
            ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
    private String reverse(char[] arr){
        int low = 0;
        int high = arr.length-1;
        while (low < high){
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return new String(arr);
    }
    static String isSumOfTwo(int N){
        for (int i = 1; i <= N/2; i++){
            int remain = N - i;
            if (isPrime(i) && isPrime(remain))
                return "Yes";
        }
        return "No";
    }
    private static boolean isPrime(int n){
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    public static int[] greaterElement (int arr[], int n) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            int num = lowerBound(clone,arr[i]);
            if (arr[num] != arr[i])
                ans[i] = num;
            else ans[i] = -100000;
        }
        return ans;
    }
    private static int lowerBound(int[] arr, int num){
        int low = 0;
        int high = arr.length-1;
        int ans = 0;
        while (low < high){
            int mid = (low + high)/2;
            if (arr[mid] < mid){
                ans = mid;
                low = mid+1;
            }
            else high = mid - 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        One o = new One();
        int[] arr = {3,5,4,6,8,9,3,4,6,0};
        quickSort(arr,0,9);
        System.out.println(Arrays.toString(arr));
    }

}
