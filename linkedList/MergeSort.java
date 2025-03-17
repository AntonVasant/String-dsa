package linkedList;

public class MergeSort {
    public Node sorting(Node head){
        if (head == null || head.next == null)
            return head;
        Node middle = findMiddle(head);
        Node next = middle.next;
        middle.next = null;
        Node left = sorting(head);
        Node right = sorting(next);
        return merge(left,right);
    }


    private Node findMiddle(Node head){
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast  = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private Node merge(Node l1, Node l2){
        Node dummy = new Node(-1);
        Node current = dummy;
        Node l1current = l1;
        Node l2current = l2;
        while (l1current != null && l2current != null){
            if (l1current.value < l2current.value){
                current.next = l1current;
                l1current = l1current.next;
            }else {
                current.next = l2current;
                l2current = l2current.next;
            }
            current = current.next;
        }
        if (l1current != null)
            current.next = l1current;
        if (l2current != null)
            current.next = l2current;
        return dummy.next;
    }
}
