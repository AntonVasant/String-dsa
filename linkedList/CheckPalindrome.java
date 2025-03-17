package linkedList;

public class CheckPalindrome {
    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node second = reverse(slow);
        while (second != null){
            if(second.value != head.value) return false;
            second = second.next;
            head = head.next;
        }
        return true;
    }

    private Node reverse(Node head){
        Node current = head;
        Node prev = null;
        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
