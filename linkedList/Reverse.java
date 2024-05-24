package linkedList;

public class Reverse {
    public Node reverseList(Node head) {
        if(head == null || head.next==null) return head;
        Node head1=reverseList(head.next);
        head.next.next = head;
        head.next= null;
        return head1;
//recursion
    }
}
