package linkedList;

public class RotateKTimes {
    public Node rotateRight(Node head, int k) {
        if(head == null || head.next == null) return head;
        int length = 1;
        Node current = head;
        while(current.next != null){
            current = current.next;
            length++;
        }
        current.next = head;
        k = k % length;
        int step = length - k;
        Node newTail = head;
        for(int i = 1; i < step; i++){
            newTail = newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
