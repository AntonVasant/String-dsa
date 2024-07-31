package linkedList;

public class DoubleNumber {
    public Node doubleIt(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null){
           sb.append(head.value);
            head = head.next;
        }
        int n = Integer.parseInt(sb.toString());
        Node dummy = new Node(-1);
        Node current = dummy;
        n = n *2;
        while (n > 0 ){
            int cur = n%10;
            Node node = new Node(cur);
            current.next = node;
            current = current.next;
            n /= 10;
        }
        return dummy.next;
    }
}
