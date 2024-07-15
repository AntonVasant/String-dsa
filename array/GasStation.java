package array;

import java.util.PriorityQueue;

public class GasStation {
    public static double findSmallestMaxDist(int stations[], int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0],a[0]));
        for(int i = 1; i < stations.length; i++){
            pq.offer(new double[]{stations[i]-stations[i-1],1});
        }

        for(int i = 0; i < k; i++){
            double[] current = pq.poll();
            current[0] = current[0]*current[1]/(current[1]+1);
            current[1] = current[1]+1;
            pq.offer(current);
        }
        return pq.peek()[0];
    }
}
