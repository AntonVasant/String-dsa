import java.util.*;

class Practice {


    public static String[] winner(String arr[], int n){
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr)
            map.put(s, map.getOrDefault(s, 0)+1);

        String smaller = arr[0];
        int largest = map.get(smaller);
        for (String s : map.keySet()){
            if (map.get(s) > largest || map.get(s) == largest && s.compareTo(smaller) < 0){
                smaller = s;
                largest = map.get(s);
            }
        }
        String number = String.valueOf(map.get(smaller));
        return new String[]{smaller, number};
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        int n = routes.length;
        for (int i = 0; i < n; i++){
            for (int num : routes[i]){
                map.putIfAbsent(num, new HashSet<>());
                map.get(num).add(i);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{source, 0});
        boolean[] visit  = new boolean[n];
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int stop = cur[1];
            int place = cur[0];
            if (place == target)
                return stop;
            for (int index : map.get(place)){
                if (visit[index]) continue;
                for (int i : routes[index]){
                    if (!set.contains(i)){
                        set.add(i);
                        queue.offer(new int[]{i, stop + 1});
                    }
                }

                visit[index] = true;
            }
        }

        return -1;
    }


    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] f = new int[n+1];
        for (int i = 0; i < n; i++) {
            f[A[i]]++;  // Increment frequency for element A[i]
            f[B[i]]++;  // Increment frequency for element B[i]

            // If A[i] and B[i] both appear twice, they are common
            if (f[A[i]] == 2) ans[i]++;
            if (f[B[i]] == 2 && A[i] != B[i]) ans[i]++;  // Avoid double counting

            // Carry forward the previous count of common elements
            if (i > 0) ans[i] += ans[i - 1];
        }

        return ans;
    }



    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) ||
                    (i % 2 == 1 && nums[i] < nums[i + 1])) {
                // Swap the elements
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }

}