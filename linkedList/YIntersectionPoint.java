package linkedList;

public class YIntersectionPoint {

    int intersectPoint(Node head1, Node head2) {
        int one = findLength(head1);
        int two = findLength(head2);

        while (one > two){
            one--;
            head1 = head1.next;
        }

        while (two > one){
            two--;
            head2 = head2.next;
        }

        while (head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1.value;
    }

    private int findLength(Node head){
        int len = 0;
        while (head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}
