package array;

import java.math.BigInteger;
import java.util.PriorityQueue;

public class KthLargestBigIntString {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq  = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            pq.offer(new BigInteger(nums[i]));
        }
        for(int i = k; i < nums.length; i++){
            BigInteger current = new BigInteger(nums[i]);
            if(current.compareTo(pq.peek()) > 0){
                pq.poll();
                pq.offer(current);
            }
        }
        return pq.peek().toString();
    }
}

