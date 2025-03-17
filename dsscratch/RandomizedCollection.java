package dsscratch;

import java.util.*;
class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random random;


    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean inserted = !map.containsKey(val);
        map.putIfAbsent(val,new HashSet<>());
        list.add(val);
        map.get(val).add(list.get(list.size()-1));
        return inserted;
    }

    //todo
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        Set<Integer> set = map.get(val);
        int index = set.stream().findFirst().orElse(-1);
        set.remove(index);
        int lastIndex = list.get(list.size()-1);
        map.get(lastIndex).remove(list.size()-1);
        map.get(lastIndex).add(index);
        list.set(index,lastIndex);
        return true;
    }
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
    static void reverse(Stack<Integer> s){
        if (s.isEmpty())
            return;
        int top = s.pop();
        reverse(s);
        reverseHelper(s,top);
    }
    private static void reverseHelper(Stack<Integer> stack, int value){
        if (stack.isEmpty()){
            stack.push(value);
            return;
        }

        int top = stack.pop();
        reverseHelper(stack,value);
        stack.push(top);
    }




    static int minSteps(int d) {
        return getMinimumSteps(d,0,0);
    }
    private static int getMinimumSteps(int target, int current,int index){
        if (current == target)
            return index;
        if ( current < target){
            return 1 + getMinimumSteps(target,current+1,index+1);
        }
        else return  1 + getMinimumSteps(target,current -1, index+1);
    }
    int countPartitions(int[] arr, int d) {
        int sum = Arrays.stream(arr).sum();
        if (sum + d % 2 != 0 || sum < d)
            return 0;
        int target = (sum + d)/2;
        return helper(arr,target);
    }
    private int helper(int[] arr,int target){
        int[] dp = new int[target+1];
        for (int num : arr){
            for (int j = target; j >= num; j--)
                dp[j] += dp[j - num];
        }
        return dp[target];
    }
    public void segregateElements(int[] arr) {

    }
    public static void main(String[] args) {
        System.out.println(minSteps(10));
    }
}
