package linkedList;

public class SwapNode {
    public Node swapPairs(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node current = prev.next;
        while(current != null && current.next != null){
            Node second = current.next;
            Node next = second.next;
            second.next = current;
            current.next = next;
            prev.next = second;
            prev = current;
            current = next;
        }
        return dummy.next;
    }
}
