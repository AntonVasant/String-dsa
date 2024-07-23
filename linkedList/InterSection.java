package linkedList;

public class InterSection {
    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node temp1 = headA;
        Node temp2 = headB;

        while (temp1 != temp2) {
            // If either pointer reaches the end of its list, switch it to the other list's head.
            temp1 = (temp1 == null) ? headB : temp1.next;
            temp2 = (temp2 == null) ? headA : temp2.next;
        }

        return temp1;
    }

}
