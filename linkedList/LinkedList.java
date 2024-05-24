package linkedList;

public class LinkedList {
    public Node create(int array[]){
        Node head = new Node(array[0]);
        Node current = head;
        for(int i=1;i< array.length;i++){
            current.next = new Node(array[i]);
            current = current.next;
        }
        return head;
    }

}
