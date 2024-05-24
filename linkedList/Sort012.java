package linkedList;

public class Sort012 {
    public Node sort(Node head){
        Node dummy0 = new Node(-1);
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);
        Node current = head;
        while(current != null){
            if(current.value == 0){
                dummy0.next = current;
                current = current.next;
            } else if (current.value == 1) {
                dummy1.next = current;
                current=current.next;
            }else {
                dummy2.next=current;
                current=current.next;
            }
        }
        dummy0.next=dummy1.next;
        dummy1.next=dummy2.next;
        dummy2.next = null;
        return dummy0.next;
    }
}
