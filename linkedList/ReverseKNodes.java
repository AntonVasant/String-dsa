package linkedList;

public class ReverseKNodes {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) return head;
        int count = 0;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node nex = dummy;
        Node current = dummy;
        while (current.next != null){
            current = current.next;
            count++;
        }
        while (count >= k){
            current = prev.next;
            nex = current.next;
            for(int i = 1; i < k; i++){
                current.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = current.next;
            }
            prev = current;
            count -= k;
        }
        return dummy.next;
    }
}
