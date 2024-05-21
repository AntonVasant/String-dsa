package linkedList;

import java.util.PriorityQueue;

public class MergeKList {
    public Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        for(Node list : lists){
            if(list != null)
                pq.add(list);
        }
        Node dummy = new Node(-1);
        Node current = dummy;
        while(!pq.isEmpty()){
            Node small = pq.poll();
            current.next = small;
            current = current.next;
            if(small.next != null)
                pq.add(small.next);
        }
        return dummy.next;
    }
}
