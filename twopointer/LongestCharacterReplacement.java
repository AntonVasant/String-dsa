package twopointer;

import java.util.*;

public class LongestCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int maximum = 0;
        int length = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            hash[s.charAt(right)- 'A']++;
            maximum = Math.max(maximum,hash[s.charAt(right) - 'A']);
            if (((right-left+1) - maximum) > k){
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            length = Math.max(length,right-left+1);
        }
        return length;
    }


    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    void push(int a){
        q2.add(a);
        while (!q1.isEmpty())
            q2.add(q1.poll());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    int pop(){
        if (q1.isEmpty())
            return -1;
        return q1.poll();
    }

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x){
        s2.push(x);
    }
    int Pop()
    {
        if (s1.isEmpty()){

            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        if (s1.isEmpty()) return -1;
        return s1.pop();
    }


    static int[] kthLargest(int k, int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(arr[i]);
            if (pq.size() > k)
                pq.poll();
            if (k <= 0 || pq.size() < k)
                arr[i] = -1;
            else arr[i] = pq.peek();
        }
        return arr;
    }


    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int maxIndex = 0;

        for (int i = 1; i < k; i++){
            if (arr[maxIndex] < arr[i])
                maxIndex = i;
        }
        list.add(arr[maxIndex]);
        for (int i = k; i < n; i++){
            if (maxIndex < i - k + 1){
                maxIndex = maxIndex + 1;
                for (int j = maxIndex; j <= i; j++){
                    if (arr[j] > arr[maxIndex])
                        maxIndex = j;
                }
            }
            else if (arr[maxIndex] < arr[i])
                maxIndex = i;

            list.add(arr[maxIndex]);
        }
        return list;
    }
    public static int maxValue(int arr[]) {
        int min1= Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            max1 = Math.max(max1, arr[i] + i);
            min1 = Math.min(min1, arr[i] + i);

            max2 = Math.max(max2, arr[i] - i);
            min2 = Math.min(min2, arr[i] - i);
        }

        return Math.max(max1 - min1, max2 - min2);
    }


    public static int countSubarraysGreaterThanK(int[] arr, int K) {
        int n = arr.length;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop(); // Remove elements that are smaller than the current element
            }
            count += (stack.isEmpty() ? i + 1 : i - stack.peek());

            // Push the current index into the stack
            stack.push(i);
        }

        System.out.println(count);
        return count;
    }


    public static void main(String[] args) {

    }
}
