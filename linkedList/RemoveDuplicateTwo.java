package linkedList;

public class RemoveDuplicateTwo {
    public Node deleteDuplicates(Node head) {
        Node dummy = new Node(0);
        Node current = head;
        dummy.next = head;
        Node prev = dummy;
        while (current != null){
            while (current.next != null && current.value == current.next.value){
                current = current.next;
            }
            if (prev.next != current){
                prev.next = current.next;
            }else prev = prev.next;
            current = current.next;
        }
        return dummy.next;
    }
}
