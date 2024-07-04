package linkedList;

public class Partition {
    public Node partition(Node head, int x) {
        Node lessDummy = new Node(0);
        Node greaterDummy  = new Node(0);
        Node less = lessDummy;
        Node higher = greaterDummy;
        Node current = head;
        while (current != null){
            if( current.value < x){
                less.next = current;
                less = less.next;
            }else{
                higher.next = current;
                higher = higher.next;
            }
            current = current.next;
        }
        less.next = greaterDummy.next;
        higher.next = null;
        return lessDummy.next;
    }
}
