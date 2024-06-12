package linkedList;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public void merge(Node head1,Node head2,Node head3){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        pq.offer(head1);
        pq.offer(head2);
        pq.offer(head3);
        Node dummy = new Node(-1);
        Node current = dummy;
        while(!pq.isEmpty()){
            var smallNode = pq.poll();
            current.next = smallNode;
            current = current.next;
            if (smallNode.next != null){
                pq.offer(smallNode.next);
            }
        }
              while (dummy != null){
                  System.out.println(dummy.value);
                  dummy = dummy.next;
              }
    }
}


