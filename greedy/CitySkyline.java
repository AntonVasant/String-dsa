package greedy;

import java.util.*;

public class CitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                int[] cur = helper(grid,row,col,i,j);
                count += grid[i][j] == Math.max(cur[0],cur[1]) ? 0 : Math.min(cur[0],cur[1]);
            }
        }
        return count;
    }


    private int[] helper(int[][] grid,int row,int col,int x,int y){
        int[] ans = new int[2];
        int limit = Math.max(row,col);
        for (int i = 0; i < limit; i++){
            if (row <= i)
                ans[0] = Math.max(ans[0],grid[i][y]);
            if (col <= i)
                ans[1] = Math.max(ans[1],grid[x][i]);
        }
        return ans;
    }


    //Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
    public static int findMaxLength(int[] nums) {
        int sum = 0;
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int right = 0; right < nums.length; right++){
            sum += nums[right] == 1 ? 1 : -1;
            if (map.containsKey(sum))
                len = Math.max(len,right - map.get(sum));
            else map.put(sum,right);
        }
        return len;
    }

    //brick cutting -> 554 cut in the gap
    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer , Integer> map = new HashMap<>();
        for (List<Integer> list : wall){
            int count = 0;
            for (int i = 0; i < list.size()-1;i++){
                count += list.get(i);
                map.put(count,map.getOrDefault(count,0)+1);
            }
        }
        int max = 0;
        for (int n : map.values())
            max = Math.max(max,n);
        return wall.size()-max;
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()){
            int num = 0;
            if (!pq.isEmpty())
                num = pq.poll();
            num--;
            if (num > 0)
                queue.add(new int[]{num, time + n});
            if (!queue.isEmpty() && queue.peek()[1] <= time)
                pq.offer(queue.poll()[0]);
        }
        return time;
    }

    class Element{
        int value;
        int listIndex;
        int index;
        public Element(int value,int listIndex,int index){
            this. value = value;
            this.listIndex = listIndex;
            this.index = index;
        }
    }

    public  int[] smallestRange(List<List<Integer>> nums) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        for (int i = 0; i < nums.size(); i++){
            pq.offer(new Element(nums.get(i).get(0),i,0));
            max = Math.max(max,nums.get(i).get(0));
        }
        int  start = 0;
        int end = Integer.MAX_VALUE;
        while (pq.size() == nums.size()){
            Element current = pq.poll();
            int currentValue = current.value;
            if (max - currentValue < end - start){
                end = max;
                start = currentValue;
            }
            if (nums.get(current.listIndex).size() > current.index+1){
                int value = nums.get(current.listIndex).get(current.index+1);
                pq.offer(new Element(value,current.listIndex,current.index+1));
                max = Math.max(value,max);
            }
        }
        return  new int[]{start,end};
    }

    class Pair{
        String key;
        int value;

        public Pair(String key, int value){
            this.key = key;
            this.value = value;
        }


    }

    public int minStickers(String[] stickers, String target) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(target, 0));
        while (!queue.isEmpty()){
            Pair current = queue.poll();
            if (current.key.isEmpty())
                return current.value;
            for (int i = 0; i < stickers.length; i++){
                String s = getString(stickers[i], current.key);
                queue.offer(new Pair(s, current.value+1));
            }
        }
        return -1;
    }

    private String getString(String sticker, String small){
        StringBuilder builder = new StringBuilder(small);
        for (int i = 0; i < sticker.length(); i++){
            int index = builder.indexOf(sticker.charAt(i)+"");
            if (index >= 0)
                builder.deleteCharAt(index);
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(4,10,15,24,26)));
        list.add(new ArrayList<>(Arrays.asList(0,9,12,20)));
        list.add(new ArrayList<>(Arrays.asList(5,18,22,30)));
        CitySkyline skyline = new CitySkyline();
        skyline.smallestRange(list);
    }
}
