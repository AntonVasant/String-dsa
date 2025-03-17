package twopointer;

import java.util.*;

public class FindKClosestNumbers {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;
        while (right - left >= k){
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x))
                left++;
            else right--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++){
            list.add(arr[i]);
        }
        return list;
    }

    public ArrayList<Integer> sortByFreq(int[] arr) {
       PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
               new PriorityQueue<>((a,b) -> Objects.equals(a.getValue(), b.getValue()) ?
                       a.getKey() - b.getKey() : b.getValue() - a.getValue());
       Map<Integer, Integer> map = new HashMap<>();
       for (int num : arr)
           map.put(num, map.getOrDefault(num, 0) + 1);
       priorityQueue.addAll(map.entrySet());
       ArrayList<Integer> list = new ArrayList<>();
       while (!priorityQueue.isEmpty()){
           Map.Entry<Integer, Integer> entry = priorityQueue.poll();
           int times = entry.getValue();
           for (int i = 0; i < times; i++){
               list.add(entry.getKey());
           }
       }
       return list;

    }
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M){
        int[] ans = new int[N];
        Arrays.sort(A1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int index = 0;
        for (int num : A2){
            if (map.containsKey(num)){
                int times = map.get(num);
                for (int i = 0; i < times; i++) {
                    ans[index++] =  num;
                }
                map.remove(num);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int times = entry.getValue();
            for (int i = 0; i < times; i++)
                list.add(entry.getKey());
        }
        Collections.sort(list);

        for (int num : list) {
            ans[index++] = num;
        }
        return ans;
    }
    public List<List<Integer>> fourSum(int[] arr, int target) {

        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++){
            if (i > 0 && arr[i] == arr[i-1]) continue;
            for (int j = i+1; j < n; j++){
                if (j > i + 1 && arr[j] == arr[j-1]) continue;;
                int k = j + 1;
                int l = n-1;
                while (k < l){
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum < target){
                        k++;
                    }
                    else if (sum > target){
                        l--;
                    }
                    else {
                        list.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l])));
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k+1]) k++;
                        while (k < l && arr[l] == arr[l-1]) l--;
                    }
                }
            }
        }
        return list;
    }
    char firstRep(String S){
        char ans = '#';
        int index = 0;
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (char c  : S.toCharArray()){
            if (map.containsKey(c)){
                if (min > map.get(c)){
                    ans = c;
                    min = map.get(c);
                }
            }
            map.put(c, index++);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
//leetcode