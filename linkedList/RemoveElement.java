package linkedList;

public class RemoveElement {
    public Node removeElements(Node head, int val) {
        if (head == null) return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
        while (current != null) {
            if (current.value == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }

}
