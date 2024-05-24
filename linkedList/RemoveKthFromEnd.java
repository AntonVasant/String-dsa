package linkedList;

public class RemoveKthFromEnd {
    public Node removeNthFromEnd(Node head, int n) {
        if (head == null) return null;

        Node dummy = new Node(0);
        dummy.next = head;
        Node front = dummy;
        Node back = dummy;

        // Move front pointer `n + 1` steps ahead
        for (int i = 0; i <= n; i++) {
            front = front.next;
        }

        // Move both pointers until front reaches the end
        while (front != null) {
            front = front.next;
            back = back.next;
        }

        // Remove the nth node from the end
        back.next = back.next.next;

        return dummy.next;
    }

}
