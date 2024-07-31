package linkedList;

public class AddTwoNumber2 {
    public Node addTwoNumbers(Node l1, Node l2) {
        Node li1 = reverse(l1);
        Node li2 = reverse(l2);
        Node dummy = new Node(-1);
        Node cur = dummy;
        int sum = 0;
        int carry = 0;
        while (li1 != null || li2 != null){
            sum = carry;
            if (li1 != null){
                sum += li1.value;
                li1 = li1.next;
            }
            if (li2 != null){
                sum += li2.value;
                li2 = li2.next;
            }
            Node newNode = new Node(sum%10);
            cur.next = newNode;
            cur = cur.next;
            carry = sum/10;
        }
        if (carry > 0){
            Node node = new Node(carry);
            cur.next = node;
        }
        Node ans = reverse(dummy.next);
        return ans;
    }

    private Node reverse(Node head){
        Node cur  = head;
        Node prev = null;
        while (cur != null){
            Node nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}
