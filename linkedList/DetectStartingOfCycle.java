package linkedList;

public class DetectStartingOfCycle {
    public Node detectCycle(Node head) {
        if(head == null) return null;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        if(fast.next == null || fast.next.next == null) return null;
        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
