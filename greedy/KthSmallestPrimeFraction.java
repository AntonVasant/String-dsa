package greedy;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));
        int n = arr.length;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                double division = (double) arr[i] /arr[j];
                pq.offer(new double[]{division,arr[i],arr[j]});
                if (pq.size() > k)
                    pq.poll();
            }
        }
        double[] d = pq.poll();
        return new int[]{(int)d[1],(int)d[2]};
    }
}
