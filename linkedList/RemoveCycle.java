package linkedList;

public class RemoveCycle {
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) return;
        Node slow = head;
        Node fast = head;
        boolean found = false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                found = true;
                break;
            }
        }

        if (!found) return;

        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        Node cycle = slow;
        Node ptr = cycle;
        while (cycle.next != ptr){
            cycle = cycle.next;
        }
        cycle.next = null;
    }
}
