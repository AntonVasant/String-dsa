package greedy;

import java.util.*;

public class AssignWorkMaximumProfit {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);

        int[] maxProfit = new int[n];
        maxProfit[0] = arr[0][1];

        for (int i = 1; i < n; i++)
            maxProfit[i] = Math.max(maxProfit[i-1],arr[i][1]);

        int ans = 0;
        for (int workers : worker){
            int left = 0;
            int right = n-1;
            int mid;
            while (left <= right){
                mid = (left + right)/2;
                if (workers >= arr[mid][0])
                    left = mid +1;
                else  right = mid - 1;
            }

            if (right >= 0) ans += maxProfit[right];
        }
        return ans;
    }




    int minCost(int[] height) {
        int n = height.length;
        if (n == 1) return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);

        for (int i = 2; i < n; i++) {
            int jumpOne = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int jumpTwo = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            dp[i] = Math.min(jumpOne, jumpTwo);
        }

        return dp[n - 1];
    }
    class Edge{

        int dest;
        int cost;
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] arr : flights){
            graph.putIfAbsent(arr[0], new ArrayList<>());
            graph.get(arr[0]).add(new int[]{arr[1], arr[2]});
        }

        int[] minCosts = new int[n];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0,0});
        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int currentStop = current[0];
            int cost = current[1];
            int stops = current[2];
            if (currentStop == dst) return cost;
            if (stops > k) continue;
            for (int[] nextStops : graph.getOrDefault(currentStop, new ArrayList<>())){
                if (cost + nextStops[1] < minCosts[nextStops[0]]){
                    pq.offer(new int[]{nextStops[0], cost + nextStops[1],stops+1});
                    minCosts[nextStops[0]] = cost + nextStops[1];
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[][] flights = new int[][]{{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        System.out.println(findCheapestPrice(5, flights, 0, 2, 2));
    }

    /*
    Given an array of integers cost[] where cost[i] is the cost of the ith step on a staircase.
    Once the cost is paid, you can either climb one or two steps.
    You can either start from the step with index 0, or the step with index 1.
    Return the minimum cost to reach the top of the floor.
     */
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int takeOneStep = dp[i - 1] + cost[i - 1];
            int takeTwoSteps = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(takeOneStep, takeTwoSteps);
        }

        return dp[n];
    }


}

/*
* Given two arrays difficulty and profit, representing the difficulty and profit of various jobs, respectively,
*  and an array worker representing the abilities of workers, assign jobs to workers in a way that maximizes the
* total profit earned. Each worker can only be assigned one job, and a worker must have an ability greater than or
*  equal to the job's difficulty to be assigned to it.

Example:

difficulty = [2, 4, 6]
profit = [2, 5, 7]
worker = [3, 1, 4]
In this example:

Worker 1 (ability 3) can be assigned to job 1 (difficulty 2) or job 2 (difficulty 4).
Worker 2 (ability 1) cannot be assigned to any job.
Worker 3 (ability 4) can be assigned to job 1, job 2, or job 3.
The optimal assignment would be:

Worker 1: Job 2 (profit 5)
Worker 2: No job
Worker 3: Job 3 (profit 7)
The total profit earned would be 5 + 0 + 7 = 12.*/