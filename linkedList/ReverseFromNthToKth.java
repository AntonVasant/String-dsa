package linkedList;

public class ReverseFromNthToKth {
    public static Node reverse(int n,int k,Node head){
        Node dummy = new Node(-1);
        Node prev = dummy;
        prev.next=head;
        for (int i = 0;i < n-1; i++){
            prev = prev.next;
        }
        Node start = prev.next;
        Node current  = start.next;
        for (int i = 0; i < k-n; i++){
            start.next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = start.next;
        }
        return dummy;
    }
}
