package rescursion;



import linkedList.Node;

import java.util.*;

public class PermutationsArray {
    public static void permutations(int[] array){
        Set<List<Integer>> list = new HashSet<>();
        boolean[] flag = new boolean[array.length];
        List<Integer> lt = new ArrayList<>();
        helper(list,array,0,flag,lt);
        for (List<Integer> l : list)
            System.out.println(l);
    }

    private static void helper(Set<List<Integer>> list,int[] array,int index,boolean[] flags,List<Integer> ans){
        if (index == array.length){
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < array.length; i++){
            if (!flags[i]){
                flags[i] = true;
                ans.add(array[i]);
                helper(list, array, index+1, flags, ans);
                flags[i] = false;
                ans.remove(ans.size()-1);
            }

        }
    }


    //gas station distance
    public static double findSmallestMaxDist(int stations[], int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));
        for (int i = 1; i < stations.length; i++){
            pq.offer(new double[]{stations[i] - stations[i-1],1});
        }
        while (k > 0){
            double[] current = pq.poll();
            double dis = current[0];
            double count = current[1];
            double newDist = dis * count/(count+1);
            pq.offer(new double[]{newDist,count+1});
            k--;
        }

        assert pq.peek() != null;
        return pq.peek()[0];
    }


    //next greater
    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        stack.push(arr[n-1]);
        for (int i = n-2; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() < arr[i])
                stack.pop();
            if (!stack.isEmpty())
                list.add(stack.peek());
            else list.add(-1);
            stack.push(arr[i]);
        }
        Collections.reverse(list);
        list.add(-1);
        return list;
    }

    public String isSubset( long a1[], long a2[], long n, long m) {
        Map<Long,Integer> map = new HashMap<>();
        for (long num : a1)
            map.put(num,map.getOrDefault(num,0)+1);
        for (long num : a2){
            if (map.containsKey(num)){
                map.put(num,map.getOrDefault(num,0)-1);
                if (map.get(num) == 0)
                    map.remove(num);
            }
            else return "No";
        }
        return "Yes";
    }


    public static ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (i % k == 0)
                left[i] = arr[i];
            else left[i] = Math.max(left[i-1],arr[i]);
        }

        for (int i = n-1; i >= 0; i--){
            if (i == n-1 || (i+1)%k == 0)
                right[i] = arr[i];
            else right[i] = Math.max(arr[i],right[i+1]);
        }
        for (int i = 0; i <= n-k; i++){
            System.out.println(right[i]+" "+ left[i + k - 1]);
            list.add(Math.max(right[i],left[i+k-1]));
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return list;
    }

    public static boolean areAnagrams(String s1, String s2) {
        char[] one = new char[26];
        char[] two = new char[26];
        int n = s1.length();
        if (n != s2.length()) return false;
        for (int i = 0; i < n; i++){
            one[s1.charAt(i) - 'a']++;
            two[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(one,two);
    }

    static int isPrime(int N){
        if (N <= 2) return 1;
        for (int i = 3; i <= Math.sqrt(N); i++)
            if (N % i == 0) return 1;
        return 0;
    }

    static int lcs(int n, int m, String str1, String str2) {
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] +1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int left = 0;
        int n = arr.length;
        int current = 0;
        for (int right = 0; right < n; right++){
            current += arr[right];
            while (current > target){
                current -= arr[left++];
            }
            if (current == target) return new ArrayList<>(Arrays.asList(left+1, right+1));
        }
        return new ArrayList<>(List.of(-1));
    }




    void reverseInGroups(ArrayList<Long> arr, int k) {
        int n = arr.size();
        int i = 0;
        while (n >= k){
            reverse(arr,i,i+k);
            i+=k;
            n -= k;
        }

        if (i < n-1) reverse(arr,i,n-1);
    }

    void reverse(ArrayList<Long> list, int i, int j){
        while (i < j){
            long temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(max_of_subarrays(4,new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}));
    }
}
