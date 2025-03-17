package linkedList;

public class ReOrder {
    public void reorderList(Node head) {
        if (head == null || head.next == null) return;
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node cur = slow.next;
        slow.next = null;
        Node prev = null;
        Node next;

        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        Node first = head;
        Node sec = prev;

        while (sec != null){
            next = first.next;
            first.next = sec;
            first = next;
            next = sec.next;
            sec.next = first;
            sec = next;
        }

    }
}
