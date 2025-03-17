package stack;

import java.util.*;


public class SubArrayRanges {

    /*
You are given an integer array nums. The range of a sub array of nums is the difference between the
largest and smallest element in the sub array.
Return the sum of all sub array ranges of nums.
A sub array is a contiguous non-empty sequence of elements within an array.
     */

    public long subArrayRanges(int[] nums) {
        int[] nextGreater = nextGreater(nums);
        int[] nextSmaller = nextSmaller(nums);
        int[] previousGreater = previousGreater(nums);
        int[] previousSmaller = previousSmaller(nums);
        long ans = 0L;
        for (int i = 0; i < nums.length; i++){
            ans += ((long) (nextGreater[i] - i) * (i - previousGreater[i]) * nums[i]) -
                    ((long) (nextSmaller[i] - i) * (i - previousSmaller[i]) * nums[i]);

        }
        return ans;
    }

    private int[] nextGreater(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    private int[] nextSmaller(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    private int[] previousGreater(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }


    private int[] previousSmaller(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    class Pair<T, U>{
        private T key;
        private U value;

        public Pair(T key, U value){
            this.key = key;
            this.value = value;
        }
        public T getKey(){
            return key;
        }

        public U getValue(){
            return value;
        }
    }
    public int totalSteps(int[] nums) {
        Stack<Pair<Integer,Integer>> ans=new Stack<>();
        int x=0;
        ans.push(new Pair<>(nums[nums.length-1],0));
        for(int i=nums.length-2;i>=0;i--){
            int a=0;
            while(!ans.empty() && nums[i]>ans.peek().getKey()){
                a=Math.max(a+1,ans.peek().getValue());
                ans.pop();
            }
            x=Math.max(x,a);
            ans.push(new Pair<>(nums[i],a));
        }
        return x;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int wordLength = words[0].length();
        int count = words.length;
        Map<String, Integer> freqMap = new HashMap<>();
        int found = 0;
        for (String string : words)
            map.put(string, map.getOrDefault(string, 0) + 1);
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;

            while (right < n){
                String subString = s.substring(right, right + wordLength);
                if (map.containsKey(subString)) {
                    freqMap.put(subString, freqMap.getOrDefault(subString, 0) + 1);
                    found++;


                    while (freqMap.get(subString) > map.get(subString)) {
                        String remove = s.substring(left, left + wordLength);
                        freqMap.put(remove, map.get(remove) - 1);
                        found--;
                        left += wordLength;
                    }
                }
                else {
                    freqMap.clear();
                    found = 0;
                    break;
                }

                if (found == count)
                    list.add(left);
                right += wordLength;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        SubArrayRanges ranges = new SubArrayRanges();
        System.out.println(ranges.totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11}));
    }
}
