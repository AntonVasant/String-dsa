package linkedList;

public class DeleteMiddle {
    public Node deleteMiddle(Node head) {
        if (head == null) return head;
        if (head.next == null) return null;
        Node slow = head;
        Node fast = head;
        Node prev  = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) prev.next = slow.next;
        return head;
    }
}
