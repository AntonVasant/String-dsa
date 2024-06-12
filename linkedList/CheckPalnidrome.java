package linkedList;

public class CheckPalnidrome {
    public boolean isPalindrome(Node head){
        Node fast = head;
        Node slow = head;
        while(fast.next  != null && fast.next.next != null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node secondHalf = reverse(slow.next);
       return check(head,secondHalf);
    }
    private boolean check(Node first,Node secondHalf){
        while (first != null && secondHalf != null){
            if(first.value != secondHalf.value)
                return false;
            first = first.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    private Node reverse(Node head){
        Node prev = null;
        Node current = head;
        while (current != null){
            Node next = current.next;
            current.next=prev;
            prev=current;
            current = next;
        }
        return prev;
    }
}
