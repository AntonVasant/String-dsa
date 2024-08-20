package greedy;

import java.util.Map;
import java.util.PriorityQueue;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[0] - x[0]);
        pq.offer(new int[]{a,'a'});
        pq.offer(new int[]{b,'b'});
        pq.offer(new int[]{c,'c'});
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            int[] first = pq.poll();
            if (sb.charAt(sb.length()-1) == first[1] && sb.charAt(sb.length()-2) == first[1]){
                if (pq.isEmpty()) break;
                int[] sec = pq.poll();
                sb.append((char) sec[1]);
                sec[0]--;
                if (sec[0] > 0) pq.offer(sec);
                pq.offer(first);
            }
            else {
                sb.append((char) first[1]);
                first[0]--;
                if (first[0] > 0) pq.offer(first);
            }
        }
        return sb.toString();
    }
}
