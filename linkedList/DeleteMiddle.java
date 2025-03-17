package linkedList;

public class DeleteMiddle {
    public Node deleteMiddle(Node head) {
        int count = 0;
        Node current = head;

        while (current != null){
            count++;
            current = current.next;
        }
        current = head;
        if(count == 1){
            return current.next;
        }
        int n = (count / 2) - 1;
        for(int i = 0; i < n; i++){
            current = current.next;
        }

        current.next = current.next.next;
        return head;
    }
}
